package hu.schonherz.java.training.main;

import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.traning.loaders.ServerReader;
import hu.schonherz.java.traning.loaders.SystemAdministratorReader;

public class Main {
    
    public static void main(final String... args) {
        try {
            do
            {
                
                List<Server> servers = ServerReader.readFromFile("files/servers.txt");
                List<SystemAdministrator> sysadmins = SystemAdministratorReader.readFromFile("files/sysadmins.txt", servers);
                
                for (Server s : servers) {
                    if (s.getStatus() == ServerStatus.STOPPED) {
                        System.out.println(s.getId() + " - " + s.getName() + " - " + s.getType());
                        System.out.println("----------------------------------------------");
                        
                        for (SystemAdministrator admin : sysadmins) {
                            if (admin.getServers().contains(s)) {
                                System.out.println(admin.getEmployeeID() + " - " + admin.getName());
                            }
                        }
                        
                        System.out.println();
                    }
                }
            
                Thread.sleep(2000);
            }
            while (true);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
