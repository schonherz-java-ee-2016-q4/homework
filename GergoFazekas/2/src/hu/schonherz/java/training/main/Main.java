package hu.schonherz.java.training.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;


//This class controls the runtime process
class MyRunnable implements Runnable {

    @Override
    public void run() {
        while (true) { 
            try {
                List<Server> servers = Main.getServerList(); //Get the server list
                List<SystemAdministrator> admins = Main.getAdministatorList(); //Get the administrator list
                for (Server server : servers) {
                    if (server.getStatus() == ServerStatus.STOPPED) { //Printing the stopped servers only
                        System.out.println(server.getId() + " - " + server.getName() + " - " + server.getType());
                        System.out.println("--------------------");
                        Main.printAdminsbyServer(server, admins);
                        System.out.println();
                    }
                }
                System.out.println("##################################\n");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2000); //2 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }

}
public class Main {
//Reads the servers.txt file and stores the servers in a list
    public static List<Server> getServerList() throws FileNotFoundException {
        FileReader fr = new FileReader("files/servers.txt");
        List<Server> servers = new ArrayList<>();
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            Server server = new Server();
            server.setId(Integer.parseInt(data[0]));
            server.setName(data[1]);
            server.setType(getServerType(data[2]));
            server.setStatus(getServerStatus(data[3]));
            servers.add(server);
        }
        sc.close();
        return servers;

    }

    public static List<Server> getServerListByID(List<Integer> serverIDs, List<Server> servers) {
        List<Server> s = new ArrayList<>();
        for (Server server : servers) {
            if (serverIDs.contains(server.getId())) {
                s.add(server);
            }
        }
        return s;
    }
//Reads the sysadmins.txt file and stores admin instances in a list
    public static List<SystemAdministrator> getAdministatorList() throws FileNotFoundException {
        List<SystemAdministrator> admins = new ArrayList<>();
        List<Integer> serverIDs;
        Scanner sc = new Scanner(new FileReader("files/sysadmins.txt"));
        while (sc.hasNextLine()) {
            serverIDs = new ArrayList<>();
            String[] data = sc.nextLine().split(",");
            SystemAdministrator admin = new SystemAdministrator();
            admin.setName(data[0]);
            admin.setEmployeeID(Integer.parseInt(data[1]));
            for (int i = 2; i < data.length; i++) {
                serverIDs.add(Integer.parseInt(data[i]));
            }
            admin.setServers(getServerListByID(serverIDs, getServerList()));
            admins.add(admin);
        }
        sc.close();
        return admins;
    }
//Determines the server status
    public static ServerStatus getServerStatus(String status) {
        if (status.equals("RUNNING")) {
            return ServerStatus.RUNNING;
        }
        return ServerStatus.STOPPED;
    }
//Determines the server type
    public static ServerType getServerType(String type) {
        switch (type) {
        case "LINUX":
            return ServerType.LINUX;
        case "LINUX_WEB":
            return ServerType.LINUX_WEB;
        case "LINUX_DB_AND_WEB":
            return ServerType.LINUX_DB_AND_WEB;
        case "WINDOWS":
            return ServerType.WINDOWS;
        case "WINDOWS_WEB":
            return ServerType.WINDOWS_WEB;
        default:
            return ServerType.WINDOWS_DB_AND_WEB;
        }
    }
//Determines the admin's (given as a parameter) server list
    public static List<Integer> getServerIDsByAdmin(SystemAdministrator admin) {
        List<Integer> ids = new ArrayList<>();
        for (Server server : admin.getServers()) {
            ids.add(server.getId());
        }
        return ids;
    }
//Prints the admin list to the console 
    public static void printAdminsbyServer(Server server, List<SystemAdministrator> admins) {
        for (SystemAdministrator admin : admins) {
            if (getServerIDsByAdmin(admin).contains(server.getId())) {
                System.out.println(admin.getEmployeeID() + " - " + admin.getName());
            }
        }
    }
    
    public static void main(final String... args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        t1.start();
    }
}
