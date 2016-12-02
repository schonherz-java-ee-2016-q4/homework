package hu.schonherz.training.service.impl;

import java.io.File;
import java.io.IOException;

import hu.schonherz.training.service.api.connector.Connector;
import hu.schonherz.training.service.api.reader.Reader;
import hu.schonherz.training.service.impl.connectorimpl.MyConnector;
import hu.schonherz.training.service.impl.domain.people.Employee;
import hu.schonherz.training.service.impl.domain.server.Server;
import hu.schonherz.training.service.impl.filehandlerimpl.ServerReader;
import hu.schonherz.training.service.impl.filehandlerimpl.SystemAdministratorReader;
import hu.schonherz.training.service.impl.multimapImpl.MyMultiMap;

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
