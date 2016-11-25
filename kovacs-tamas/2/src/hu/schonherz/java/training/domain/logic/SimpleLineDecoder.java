package hu.schonherz.java.training.domain.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import hu.schonherz.java.training.domain.logic.interfaces.LineDecoder;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class SimpleLineDecoder implements LineDecoder {



    @Override
    public Optional<Server> convertLineToServer(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            return Optional.empty();
        }
        final int ID_PART = 0;
        final int NAME_PART = 1;
        final int TYPE_PART = 2;
        final int STATUS_PART = 3;

        // Parse serverId
        int serId;
        try {
            serId = Integer.parseInt(parts[ID_PART]);
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }

        String name = parts[NAME_PART];

        Optional<ServerType> typeOpt = ServerType.decodeFromStr(parts[TYPE_PART]);
        Optional<ServerStatus> statusOpt = ServerStatus.decodeFromStr(parts[STATUS_PART]);
        if (!typeOpt.isPresent() || !statusOpt.isPresent()) {
            return Optional.empty();
        }

        Server decodedServer = Server.builder().id(serId).name(name).type(typeOpt.get()).status(statusOpt.get()).build();
        return Optional.of(decodedServer);
    }

    @Override
    public Optional<SystemAdministrator> convertLineToAdmin(String line, List<Server> servers) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return Optional.empty();
        }
        final int NAME_PART = 0;
        final int ID_PART = 1;
        final int FIRST_SERVER_PART = 2;

        String name = parts[NAME_PART];
        // Parse the employeeId and the serverIds
        int empId;
        List<Integer> serverIds = new ArrayList<>();
        try {
            empId = Integer.parseInt(parts[ID_PART]);
            for (int i = FIRST_SERVER_PART; i < parts.length; i++) {
                serverIds.add(Integer.parseInt(parts[i]));
            }
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }

        // Collect the Server objects that belong to the admin
        List<Server> serversOfAdmin = servers.stream()
                .filter(ser -> serverIds.contains(ser.getId()))
                .collect(Collectors.toList());

        // Create and return the admin object
        SystemAdministrator admin = new SystemAdministrator();
        admin.setName(name);
        admin.setEmployeeID(empId);
        admin.setServers(serversOfAdmin);
        return Optional.of(admin);
    }

}
