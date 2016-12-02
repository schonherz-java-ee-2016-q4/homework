package hu.schonherz.java.training.serverwriter;

import java.io.IOException;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class ServerWriter {

    List<SystemAdministrator> admins;

    public ServerWriter(List<SystemAdministrator> admins) {
        this.admins = admins;
    }

    public final static void clearConsole() throws IOException {

        final String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            System.out.flush();
            // Runtime.getRuntime().exec("wincls.cmd");

        } else {

            Runtime.getRuntime().exec("clear");
        }

    }

    public void writeServers(List<Server> servers) {

        try {
            clearConsole();
        } catch (IOException e) {
            System.out.print(e);
            System.out.println("ClearScreen not success");
        } finally {
            for (Server a : servers) {

                if (a.getStatus().equals(ServerStatus.STOPPED)) {
                    System.out.println("*************************************");
                    System.out.println(a.getId() + " - " + a.getName() + " - " + a.getType());
                    System.out.println("-------------------------------------");

                    for (SystemAdministrator b : admins) {

                        if (a.getStatus().equals(ServerStatus.STOPPED) && b.getServers().contains(a.getId())) {
                            System.out.println(b.getEmployeeID() + " - " + b.getName());

                        }
                    }
                }

            }
        }
    }

}
