package hu.schonherz.java.training.domain.people;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminReader {
	
    public static List<SystemAdministrator> readFile() {
    List<SystemAdministrator> admins = new ArrayList<>();
    String actual_line;
    
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("files/sysadmins.txt"))) {
                 
        while (( actual_line = bufferedReader.readLine()) != null ) {
              	if ( actual_line.isEmpty()) {
                continue;
              	}
   String[] attributes = actual_line.split(",");

          List<Integer> list = new ArrayList<>();
          Map<String, List<Integer>> map = new HashMap<>();
          for (int i = 2; i < attributes.length; i++) { // servers of the user
               list.add(Integer.parseInt(attributes[i]));
              }
                map.put(attributes[0], list); // user with owned servers
    SystemAdministrator admin = new SystemAdministrator(
           attributes[0],
           Integer.parseInt(attributes[1]),
           map.get(attributes[0])
           );

            admins.add(admin);
            }
        } catch (IOException e) {
            System.out.println("IO error occured.");
        }
        return admins;
    }
}