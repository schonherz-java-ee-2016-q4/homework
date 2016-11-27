package hu.schonherz.java.training.domain.server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerReader {

    private List<Server> servers;
    private List<Server> stoppedServers;

    private FileReader openFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("files/servers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fr;
    }

    public void setServers() {
        servers = new ArrayList<>();
        Scanner sc = new Scanner(openFile());
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            final Server server = new Server.ServerBuilder()
                    .id(Integer.parseInt(data[0]))
                    .name(data[1])
                    .type(ServerType.valueOf(data[2].toUpperCase()))
                    .status(ServerStatus.valueOf(data[3].toUpperCase()))
                    .build();
            servers.add(server);
        }
        sc.close();
    }
    
    public void setStoppedServers() {
        stoppedServers = new ArrayList<>();
        for (Server server : servers) {
            if (server.getStatus().equals(ServerStatus.STOPPED)) {
                stoppedServers.add(server);
            }
        }
    }
    
    public List<Server> getStoppedServers() {
        return stoppedServers;
    }
    
    
    public List<Server> getServers() {
        return servers;
    }

}



