package hu.schonherz.java.training.domain.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
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
        try (
                BufferedReader serverReader = fileLoader.getReaderForFile(Files.SERVER);
                BufferedReader adminReader = fileLoader.getReaderForFile(Files.ADMIN);
             )
        {
            List<Server> servers = parseFile(serverReader, lnDecoder::convertLineToServer);
            servers = servers.stream()
                    .filter(ser -> ser.getStatus() == ServerStatus.STOPPED)
                    .collect(Collectors.toList());
            lnDecoder.setServers(servers);
            List<SystemAdministrator> admins = parseFile(adminReader, lnDecoder::convertLineToAdmin);

            return makeMapping(servers, admins);
        } catch (FileNotFoundException fnfe) {
            throw new FileParseException("Log file not found!", fnfe);
        } catch (IOException ioe) {
            throw new FileParseException("Cannot read log file!", ioe);
        }
    }

    private MultiMap<Server, Employee> makeMapping(List<Server> servers, List<SystemAdministrator> admins) {
        MultiMap<Server, Employee> serAdminMap = new ListBasedMultiMap<>();
        for (Server ser : servers) {
            List<Employee> adminsOfServer = admins.stream()
                    .filter(admin -> admin.getServers().contains(ser))
                    .collect(Collectors.toList());
            serAdminMap.put(ser, adminsOfServer);
        }

        return serAdminMap;
    }

    private <T> List<T> parseFile(BufferedReader reader, Function<String, Optional<T>> func) throws FileNotFoundException, IOException {
        List<T> elements = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Optional<T> currentServer = func.apply(line);
            if (currentServer.isPresent()) {
                elements.add(currentServer.get());
            }
        }

        return elements;
    }

}
