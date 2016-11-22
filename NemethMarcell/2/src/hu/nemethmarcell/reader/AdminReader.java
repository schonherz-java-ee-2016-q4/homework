package hu.nemethmarcell.reader;

import hu.nemethmarcell.domain.people.SystemAdministrator;
import hu.nemethmarcell.domain.server.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marci on 2016. 11. 22..
 */
public class AdminReader {
    private static final String SUBDIRECTORY = "files";
    private static final String FILENAME = "sysadmins.txt";

    private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

    public static List<SystemAdministrator> readFromTextFile() {
        List<SystemAdministrator> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] attributes = line.split(",");
                List<Integer> lista = new ArrayList<>();
                Map<String,List<Integer>> map = new HashMap<>();
                for(int i = 2; i < attributes.length; i++){
                    lista.add(Integer.parseInt(attributes[i]));
                }
                map.put(attributes[0],lista);
                SystemAdministrator admin = new SystemAdministrator(attributes[0],
                        Integer.parseInt(attributes[1]),map.get(attributes[0]));

                result.add(admin);
            }
        } catch (IOException e) {
            System.out.println("io error");
        }
        return result;
    }
}
