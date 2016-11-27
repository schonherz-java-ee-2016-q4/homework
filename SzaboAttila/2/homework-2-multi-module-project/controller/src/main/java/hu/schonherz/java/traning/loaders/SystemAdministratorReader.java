package hu.schonherz.java.traning.loaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;

public class SystemAdministratorReader {

    public static List<SystemAdministrator> readFromFile(String path, List<Server> servers) {
        List<SystemAdministrator> sysadmins = new ArrayList<>();
        
        File sysadminsFile = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(sysadminsFile))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                
                List<Server> assignedServers = new ArrayList<>();
                
                for (int i = 2; i < columns.length; i++) {
                    int serverId = Integer.parseInt(columns[i]);
                    
                    for (Server s : servers) {
                        if (s.getId() == serverId) {
                            assignedServers.add(s);
                            break;
                        }
                    }
                    
                }
                
                SystemAdministrator newSysAdmin = new SystemAdministrator(columns[0],
                        Integer.parseInt(columns[1]), assignedServers);
                sysadmins.add(newSysAdmin);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return sysadmins;
    }
    
}
