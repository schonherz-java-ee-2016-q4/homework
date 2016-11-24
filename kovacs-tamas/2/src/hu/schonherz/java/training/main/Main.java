package hu.schonherz.java.training.main;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class Main {

    public static void main(final String... args) {
        // 1. create Runnable
        // 2. create thread and start it (daemon thread)
        // 3. wait for user input
        // 4. exit on receiving any user input
        Server server = Server.builder()
                .id(10)
                .name("Name")
                .type(ServerType.LINUX)
                .status(ServerStatus.RUNNING)
                .build();

        System.out.println(server.getId());
        System.out.println(server.getName());
        System.out.println(server.getType().name());
        System.out.println(server.getStatus().name());

    }

}
