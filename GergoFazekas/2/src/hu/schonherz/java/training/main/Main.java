package hu.schonherz.java.training.main;

import hu.schonherz.java.training.domain.people.AdminReader;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerReader;

public class Main implements Runnable{

    @Override
    public void run() {
        while (true) {
            ServerReader sr = new ServerReader();
            sr.setServers();
            sr.setStoppedServers();
            AdminReader ar = new AdminReader();
            ar.setAdmins();
            for (Server s : sr.getStoppedServers()) {
                System.out.println(s.getId() + " - " + s.getName() + " - " + s.getType());
                System.out.println("------------------------");
                ar.printAdminbyServer(s);
            }
            System.out.println("#############################\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(final String... args) {
        Thread thread = new Thread(new Main());
        thread.start();
    }
}
