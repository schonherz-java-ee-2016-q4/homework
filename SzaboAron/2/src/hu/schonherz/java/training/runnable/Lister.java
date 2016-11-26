package hu.schonherz.java.training.runnable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import hu.schonherz.java.aron9609.multimap.MyMultiMap;
import hu.schonherz.java.training.connector.MyConnector;
import hu.schonherz.java.training.connector.interfaces.Connector;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filehandling.ServerReader;
import hu.schonherz.java.training.filehandling.SystemAdministratorReader;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class Lister implements Runnable {
    @Override
    public void run() {
        try {
            Reader serverReader = new ServerReader(Paths.get("files" + File.separator + "servers.txt"));
            Reader adminReader = new SystemAdministratorReader(Paths.get("files" + File.separator + "sysadmins.txt"));
            Connector conn = new MyConnector(serverReader, adminReader);
            while (true) {
                Thread.sleep(2000);
                Runtime.getRuntime().exec("cmd /c cls");
                MyMultiMap<Server, Employee> multimap = (MyMultiMap<Server, Employee>) conn.connect();
                for (MyMultiMap.MultiMapNode<Server, Employee> n : multimap.entrySet()) {
                    System.out.println(n.getKey().toString());
                    System.out.println("---------------------------------");
                    for (Employee e : n.getValues()) {
                        System.out.println(e.toString());
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
