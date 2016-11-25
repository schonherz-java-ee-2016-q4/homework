package hu.schonherz.java.training.domain.logic;

import java.util.Collection;

import com.gmail.kovtamas1991.collections.ListBasedMultiMap;
import com.gmail.kovtamas1991.collections.MultiMap;

import hu.schonherz.java.training.domain.logic.interfaces.FileParser;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;

public class LogPrinter implements Runnable {

    private FileParser parser;
    private boolean alive;
    private final int SLEEP_TIME;

    public LogPrinter() {
        parser = new SimpleFileParser();
        alive = true;
        SLEEP_TIME = 2000;
    }

    @Override
    public void run() {
        MultiMap<Server, Employee> prevMap = new ListBasedMultiMap<>();
        while (alive) {
            try {
                MultiMap<Server, Employee> serAdminMap = parser.getStoppedServersAndTheirAdmins();
                for (Server ser : serAdminMap.keySet()) {
                    if (!prevMap.containsKey(ser)) {
                        printLog(ser, serAdminMap.get(ser));
                    }
                }

                prevMap = serAdminMap;

                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException ie) {
                    System.err.println("Logprinter thread was interrupted! Stopping thread...");
                    ie.printStackTrace();
                    break;
                }
            } catch (FileParseException fpe) {
                System.err.println("Failed to parse log files! Stopping thread...");
                fpe.printStackTrace();
                break;
            }
        }
    }

    public void stop() {
        alive = false;
    }

    private void printLog(Server ser, Collection<Employee> admins) {
        System.out.println(stringOfServer(ser));
        System.out.println("------------------------------------");
        admins.forEach(emp -> System.out.println(stringOfEmployee(emp)));
        System.out.println();
    }

    private String stringOfServer(Server ser) {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(ser.getId()).append("]-")
        .append('[').append(ser.getName()).append("]-")
        .append('[').append(ser.getType()).append(']');
        return sb.toString();
    }

    private String stringOfEmployee(Employee emp) {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(emp.getEmployeeID()).append("]-")
        .append('[').append(emp.getName()).append(']');
        return sb.toString();
    }

}
