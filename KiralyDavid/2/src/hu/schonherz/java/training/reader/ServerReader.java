package hu.schonherz.java.training.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class ServerReader {

    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<Server> read() {

        List<Server> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] attributes = line.split(",");
                if (attributes.length != 4) {
                    continue;

                }
                final Server server = new Server.ServerBuilder().id(Integer.parseInt(attributes[0])).name(attributes[1])
                        .type(ServerType.valueOf(attributes[2].toUpperCase()))
                        .status(ServerStatus.valueOf(attributes[3].toUpperCase())).createServer();

                result.add(server);

            }
        } catch (IOException e) {
            System.out.println("io error");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return result;
    }
}