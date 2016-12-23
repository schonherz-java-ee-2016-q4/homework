package hu.schonherz.java.training.main;

import java.io.FileNotFoundException;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.report.Reporter;
import hu.schonherz.java.training.report.StoppedServerReporter;
import hu.schonherz.java.training.utility.file.handler.FileHandlerImpl;
import hu.schonherz.java.training.utility.file.handler.FileHandler;
import hu.schonherz.java.training.utility.map.MultiMap;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(final String... args) {
        try {

            FileHandler<Server, SystemAdministrator> fileHandler = new FileHandlerImpl();
            MultiMap<Server, SystemAdministrator> serverMap;
            

            while (true) {
                serverMap = fileHandler.refresh();
                Reporter reporter = new StoppedServerReporter(serverMap);
                System.out.println(reporter.getReportString());
                Thread.sleep(2000);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}