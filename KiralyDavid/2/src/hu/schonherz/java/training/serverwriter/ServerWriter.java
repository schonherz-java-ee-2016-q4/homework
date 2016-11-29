package hu.schonherz.java.training.serverwriter;

import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class ServerWriter {

    List<SystemAdministrator> admins;

    public ServerWriter(List<SystemAdministrator> admins) {
        this.admins = admins;
    }

    public void writeServers(List<Server> servers) {

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
