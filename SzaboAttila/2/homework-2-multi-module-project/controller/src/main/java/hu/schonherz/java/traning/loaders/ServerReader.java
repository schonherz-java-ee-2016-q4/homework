package hu.schonherz.java.traning.loaders;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class ServerReader {
    public static List<Server> readFromFile(String path) {
        List<Server> servers = new ArrayList<>();
        
        File serversFile = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(serversFile))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                
                Server newServer = ServerBuilder.builder()
                        .id(Integer.parseInt(columns[0]))
                        .name(columns[1])
                        .type(ServerType.valueOf(columns[2].toUpperCase()))
                        .status(ServerStatus.valueOf(columns[3].toUpperCase()))
                        .build();
                
                
                servers.add(newServer);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return servers;
    }
}
