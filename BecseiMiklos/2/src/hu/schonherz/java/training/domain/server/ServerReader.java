package hu.schonherz.java.training.domain.server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;;

public class ServerReader {

    public static List<Server> servers;

    public static List<Server> readFile() {
    servers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("files/servers.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] attributes = line.split(",");
                if (attributes.length != 4) {
                    continue;
                }
                final Server server = new Server( 
                	(Integer.parseInt(attributes[0])), 
                	(attributes[1]),
                	(ServerType.valueOf(attributes[2].toUpperCase())),
                	(ServerStatus.valueOf(attributes[3].toUpperCase()))
                	);
                	servers.add(server);

            }
        } catch (IOException e) { System.out.println("IO error occured.");
        } catch (NumberFormatException e) { System.out.println(e); }
        		return servers;
    }
}