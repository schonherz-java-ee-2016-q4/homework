package hu.schonherz.java.training.domain.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gmail.kovtamas1991.collections.ListBasedMultiMap;
import com.gmail.kovtamas1991.collections.MultiMap;

import hu.schonherz.java.training.domain.logic.interfaces.FileLoader;
import hu.schonherz.java.training.domain.logic.interfaces.FileParser;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class SimpleFileParser implements FileParser {

    private FileLoader fileLoader;

    public SimpleFileParser() {
        fileLoader = new SimpleFileLoader();
    }



    @Override
    public MultiMap<Server, Employee> ReadStoppedServersAndTheirAdmins() throws FileParseException {
        List<Server> servers;
        List<SystemAdministrator> admins;
        try {
            servers = parseServerFile();
            admins = parseAdminFile(servers);
        } catch (FileNotFoundException fnfe) {
            throw new FileParseException("Log file not found!", fnfe);
        } catch (IOException ioe) {
            throw new FileParseException("Cannot read log file!", ioe);
        }

        MultiMap<Server, Employee> serAdminMap = new ListBasedMultiMap<>();
        for (Server ser : servers) {
            List<Employee> adminsOfServer = admins.stream()
                    .filter(admin -> admin.getServers().contains(ser))
                    .collect(Collectors.toList());
            serAdminMap.put(ser, adminsOfServer);
        }

        return serAdminMap;
    }

    private List<Server> parseServerFile() throws FileNotFoundException, IOException {
        List<Server> servers = new ArrayList<>();
        try (BufferedReader serverReader = fileLoader.getReaderForFile(Files.SERVER);) {
            String line;
            while ((line = serverReader.readLine()) != null) {
                // Read only the stopped servers
                if (line.contains(ServerStatus.STOPPED.name())) {
                    Optional<Server> currentServer = convertLineToServer(line);
                    if (currentServer.isPresent()) {
                        servers.add(currentServer.get());
                    }
                }
            }
        }

        return servers;
    }

    private List<SystemAdministrator> parseAdminFile(List<Server> servers) throws FileNotFoundException, IOException {
        BufferedReader adminReader = fileLoader.getReaderForFile(Files.ADMIN);
        List<SystemAdministrator> admins = new ArrayList<>();
        String line;
        while ((line = adminReader.readLine()) != null) {
            Optional<SystemAdministrator> currentAdmin = convertLineToAdmin(line, servers);
            if (currentAdmin.isPresent()) {
                admins.add(currentAdmin.get());
            }
        }

        return admins;
    }

    private Optional<Server> convertLineToServer(String line) {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            return Optional.empty();
        }

        // Parse serverId
        int serId;
        try {
            serId = Integer.parseInt(parts[0]);
        } catch (NumberFormatException nfe) {
            return Optional.empty();
        }

        String name = parts[1];

        Optional<ServerType> typeOpt = decodeServerTypeEnum(parts[2]);
        Optional<ServerStatus> statusOpt = decodeServerStatusEnum(parts[3]);
        if (!typeOpt.isPresent() || !statusOpt.isPresent()) {
            return Optional.empty();
        }

        Server decodedServer = Server.builder().id(serId).name(name).type(typeOpt.get()).status(statusOpt.get()).build();
        return Optional.of(decodedServer);
    }

    private Optional<SystemAdministrator> convertLineToAdmin(String line, List<Server> servers) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return Optional.empty();
        }

        String name = parts[0];
        // Parse the employeeId and the serverIds
        int empId;
        List<Integer> serverIds = new ArrayList<>();
        try {
            empId = Integer.parseInt(parts[1]);
            for (int i = 2; i < parts.length; i++) {
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

    private Optional<ServerType> decodeServerTypeEnum(String str) {
        str = str.toLowerCase();
        if (str.contains("linux")) {
            if (str.contains("web")) {
                if (str.contains("db")) {
                    return Optional.of(ServerType.LINUX_DB_AND_WEB);
                }
                return Optional.of(ServerType.LINUX_WEB);
            }
            return Optional.of(ServerType.LINUX);
        }

        if (str.contains("win")) {
            if (str.contains("web")) {
                if (str.contains("db")) {
                    return Optional.of(ServerType.WINDOWS_DB_AND_WEB);
                }
                return Optional.of(ServerType.WINDOWS_WEB);
            }
            return Optional.of(ServerType.WINDOWS);
        }

        return Optional.empty();
    }

    private Optional<ServerStatus> decodeServerStatusEnum(String str) {
        str = str.toUpperCase();
        if (str.contains(ServerStatus.RUNNING.name())) {
            return Optional.of(ServerStatus.RUNNING);
        }
        if (str.contains(ServerStatus.STOPPED.name())) {
            return Optional.of(ServerStatus.STOPPED);
        }
        return Optional.empty();
    }

}
