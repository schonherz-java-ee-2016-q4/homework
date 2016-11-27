package nemethmarcell.main;

import nemethmarcell.domain.people.SystemAdministrator;
import nemethmarcell.domain.server.Server;
import nemethmarcell.domain.server.ServerStatus;
import nemethmarcell.reader.AdminReader;
import nemethmarcell.reader.ServerReader;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Marci on 2016. 11. 22..
 */
public class Main {

    public static List<Server> list = ServerReader.readFromTextFile();
    public static List<SystemAdministrator> admin = AdminReader.readFromTextFile();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            if (list.get(i).getStatus().equals(ServerStatus.STOPPED)) {
                System.out.println(list.get(i).getId() + " " + list.get(i).getName() + " " +
                        list.get(i).getType());
            }


        }
        System.out.println("------------------");
        for (int i = 0; i < 3; i++) {
            if (list.get(i).getStatus().equals(ServerStatus.STOPPED)) {
                if (admin.get(i).getServers().contains(list.get(i).getId())) {
                    System.out.println(admin.get(i).getEmployeeID() + " " + admin.get(i).getName());
                }
            }
        }

        TimerTask task = new FileWatcher(new File("files" +
                File.separator + "servers.txt")) {

            protected void onChange(File file) {
                list = ServerReader.readFromTextFile();
                System.out.println("------------------");
                for (int i = 0; i < 4; i++) {
                    if (list.get(i).getStatus().equals(ServerStatus.STOPPED)) {
                        System.out.println(list.get(i).getId() + " " + list.get(i).getName() + " " +
                                list.get(i).getType());
                    }
                }
                System.out.println("------------------");
                for (int i = 0; i < 3; i++) {
                    if (list.get(i).getStatus().equals(ServerStatus.STOPPED)) {
                        if (admin.get(i).getServers().contains(list.get(i).getId())) {
                            System.out.println(admin.get(i).getEmployeeID() + " " + admin.get(i).getName());
                        }
                    }
                }
                System.out.println("------------------");
            }
        };
        Timer timer = new Timer();

        timer.schedule(task, new Date(), 2000);


    }
}
