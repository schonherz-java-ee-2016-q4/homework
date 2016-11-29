package hu.schonherz.java.training.main;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filewriter.FileWriter;
import hu.schonherz.java.training.reader.AdminReader;
import hu.schonherz.java.training.reader.ServerReader;

public class Main {

    public static List<Server> servers = ServerReader.read();
    public static List<SystemAdministrator> admins = AdminReader.read();

    public static void main(String[] args) {

        FileWriter printout = new FileWriter(admins);
        printout.writeServers(servers);

        TimerTask task = new Observer(new File("files" + File.separator + "servers.txt")) {

            protected void onChange(File file) {
                servers = ServerReader.read();
                printout.writeServers(servers);

            }

        };
        Timer timer = new Timer();
        timer.schedule(task, new Date(), 2000);
    }
}