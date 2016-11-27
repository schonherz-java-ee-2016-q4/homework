package hu.schonherz.java.training.domain.people;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerReader;

public class AdminReader {

    private List<SystemAdministrator> admins;
    
    private FileReader openFile() {
        FileReader fr = null;
        try {
            fr = new FileReader("files/sysadmins.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fr;
    }
    
    public void setAdmins() {
        admins = new ArrayList<>();
        Scanner sc = new Scanner(openFile());
        while (sc.hasNextLine()) {
            List<Integer> serverIDs = new ArrayList<>();
            String[] data = sc.nextLine().split(",");
            SystemAdministrator admin = new SystemAdministrator();
            admin.setName(data[0]);
            admin.setEmployeeID(Integer.parseInt(data[1]));
            for (int i = 2; i < data.length; i++) {
                serverIDs.add(Integer.parseInt(data[i]));
            }
            admin.setServers(getServersByIDs(serverIDs));
            admins.add(admin);
        }
        sc.close();
    }
    
    public List<SystemAdministrator> getAdmins() {
        return admins;
    }

    
    
    public void printAdminbyServer(Server server) {
        for (SystemAdministrator a : admins) {
            for (Server s : a.getServers()) {
                if (s.getId() == server.getId()) {
                    System.out.println(a.getEmployeeID() + " - " + a.getName());
                }
            }
        }
        System.out.println();
    }
    
    public List<Server> getServersByIDs(List<Integer> ids) {
        List<Server> managedServers = new ArrayList<>();
        ServerReader sr = new ServerReader();
        sr.setServers();
        List<Server> servers = sr.getServers();
        for (Server server : servers) {
            if (ids.contains(server.getId())) {
                managedServers.add(server);
            }
        }
        return managedServers;
    } 

}



