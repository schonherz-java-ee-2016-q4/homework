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
import hu.schonherz.java.training.domain.logic.interfaces.LineDecoder;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class SimpleFileParser implements FileParser {

    private FileLoader fileLoader;
    private LineDecoder lnDecoder;

    public SimpleFileParser() {
        fileLoader = new SimpleFileLoader();
        lnDecoder = new SimpleLineDecoder();
    }



    @Override
    public MultiMap<Server, Employee> getStoppedServersAndTheirAdmins() throws FileParseException {
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
                    Optional<Server> currentServer = lnDecoder.convertLineToServer(line);
                    if (currentServer.isPresent()) {
                        servers.add(currentServer.get());
                    }
                }
            }
        }

        return servers;
    }

    private List<SystemAdministrator> parseAdminFile(List<Server> servers) throws FileNotFoundException, IOException {
        List<SystemAdministrator> admins = new ArrayList<>();
        try (BufferedReader adminReader = fileLoader.getReaderForFile(Files.ADMIN);) {
            String line;
            while ((line = adminReader.readLine()) != null) {
                Optional<SystemAdministrator> currentAdmin = lnDecoder.convertLineToAdmin(line, servers);
                if (currentAdmin.isPresent()) {
                    admins.add(currentAdmin.get());
                }
            }
        }

        return admins;
    }

}
