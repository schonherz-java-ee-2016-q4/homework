package hu.schonherz.java.training.main;

import java.util.Timer;
import java.util.TimerTask;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class Main {

    public static void main(final String... args) {
        ServerReader serverReader = new ServerReader();
        SysAdminReader adminReader = new SysAdminReader();
        Connecter connecter = new Connecter();

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                serverReader.ServerReaderStart();
                adminReader.SysAdminReaderStart(serverReader.getServerList());

                for (Server dummyserver : serverReader.getServerList()) {
                    try {
                        if (dummyserver.getStatus().equals(ServerStatus.valueOf("STOPPED"))) {
                            System.out.println();
                            System.out.println(
                                    dummyserver.getId() + "-" + dummyserver.getName() + "-" + dummyserver.getType());
                            System.out.println("----------------------------------------------");

                            for (SystemAdministrator dummyadmin : connecter.Connect(dummyserver.getId(), adminReader)) {

                                System.out.println(dummyadmin.getEmployeeID() + "-" + dummyadmin.getName());

                            }
                        }
                    } catch (Exception e) {
                        System.out.println("ERROR");
                    }
                }
            }
        };

        timer.schedule(task, 0, 2000);

    }

}