package hu.schonherz.java.training.runnable;

import java.io.File;
import java.io.IOException;

import hu.schonherz.java.aron9609.multimap.MyMultiMap;
import hu.schonherz.java.training.connector.MyConnector;
import hu.schonherz.java.training.connector.interfaces.Connector;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filehandling.ServerReader;
import hu.schonherz.java.training.filehandling.SystemAdministratorReader;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class Lister implements Runnable {
    private final File serverFile;
    private final File sysAdminFile;

    public Lister(File serverFile, File sysAdminFile) {
        super();
        this.serverFile = serverFile;
        this.sysAdminFile = sysAdminFile;
    }

    @Override
    public void run() {
        Reader serverReader = null;
        Reader adminReader = null;
        try {
            serverReader = new ServerReader(serverFile);
            adminReader = new SystemAdministratorReader(sysAdminFile);
            Connector conn = new MyConnector(serverReader, adminReader);
            while (true) {
                Thread.sleep(2000);
                MyMultiMap<Server, Employee> multimap = (MyMultiMap<Server, Employee>) conn.connect();
                for (MyMultiMap.MultiMapNode<Server, Employee> n : multimap.entrySet()) {
                    System.out.println(n.getKey().toString());
                    System.out.println("---------------------------------");
                    for (Employee e : n.getValues()) {
                        System.out.println(e.toString());
                    }
                }
            }
        } catch (IOException | InterruptedException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        } finally {
            serverReader.close();
            adminReader.close();
        }
    }
}
