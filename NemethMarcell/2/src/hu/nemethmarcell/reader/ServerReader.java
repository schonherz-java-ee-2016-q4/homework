package hu.nemethmarcell.reader;

import hu.nemethmarcell.domain.server.Server;
import hu.nemethmarcell.domain.server.ServerStatus;
import hu.nemethmarcell.domain.server.ServerType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerReader {
    // Constans
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "servers.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
    public static List<Server> result;

    public static List<Server> readFromTextFile() {
        result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");

                Server server = new Server.ServerBuilder(Integer.parseInt(attributes[0]), attributes[1],
                        ServerType.valueOf(attributes[2].toUpperCase()), ServerStatus.valueOf(attributes[3].toUpperCase())).build();

                result.add(server);

            }
        } catch (IOException e) {
            System.out.println("io error");
        }
        return result;
    }
}