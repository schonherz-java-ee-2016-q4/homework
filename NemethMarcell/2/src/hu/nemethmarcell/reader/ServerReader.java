package hu.nemethmarcell.reader;

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

    private static File file = new File("c:/Users/Marci/Desktop/KepzesFajlok/homework/NemethMarcell/2/files/servers.txt");
    public static List<String> result;

    public static List<String> readFromTextFile() {
        result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");

                // Server server = new
                // Server(Integer.parseInt(attributes[0]),attributes[1],
                // Enum.valueOf(ServerType.class, attributes[2]),
                // Enum.valueOf(ServerStatus.class, attributes[3]));
                // result.add(server);
                result.add(attributes[0]);
                result.add(attributes[1]);
                result.add(attributes[2]);
                result.add(attributes[3]);

            }
        } catch (IOException e) {
            System.out.println("io error");
        }
        return result;
    }
}
