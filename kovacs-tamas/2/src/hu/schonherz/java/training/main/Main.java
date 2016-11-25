package hu.schonherz.java.training.main;

import com.gmail.kovtamas1991.collections.MultiMap;

import hu.schonherz.java.training.domain.logic.SimpleFileParser;
import hu.schonherz.java.training.domain.logic.interfaces.FileParser;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;

public class Main {

    public static void main(final String... args) throws Exception {
        // 1. create Runnable
        // 2. create thread and start it (daemon thread)
        // 3. wait for user input
        // 4. exit on receiving any user input
        FileParser parser = new SimpleFileParser();
        MultiMap<Server, Employee> map = parser.getStoppedServersAndTheirAdmins();

        if (map.size() > 0) {
            for (Server ser : map.keySet()) {
                System.out.println(ser);
                for (Employee emp : map.get(ser)) {
                    System.out.println(emp);
                }
            }
        }

    }

}
