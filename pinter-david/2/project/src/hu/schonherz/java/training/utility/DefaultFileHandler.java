package hu.schonherz.java.training.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class DefaultFileHandler implements FileHandler<Server, SystemAdministrator> {

    private final String projectDir = "project";
    private final String filesDir = "files";
    private final String serverFile = "servers.txt";
    private final String sysadminFile = "sysadmins.txt";

    private File serverCache;
    private File sysadminCache;

    private final Path pathToServerFile = Paths.get("2", projectDir, filesDir, serverFile);
    private final Path pathToSysadminFile = Paths.get("2", projectDir, filesDir, sysadminFile);

    public DefaultFileHandler() throws FileNotFoundException {
        serverCache = pathToServerFile.toFile();

        if (!serverCache.exists()) {
            throw new FileNotFoundException("Server file not found");
        }

        sysadminCache = pathToSysadminFile.toFile();

        if (!sysadminCache.exists()) {
            throw new FileNotFoundException("Sysadmin file not found");
        }

    }

    @Override
    public MultiMap<Server, SystemAdministrator> read() {
        
        Map<Integer, Server> serversById = new HashMap<>();
        ServerBuilder serverBuilder = new ServerBuilder();

        List<SystemAdministrator> sysAdminList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(serverCache))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(",");
                Server tmpServer = serverBuilder.id(Integer.parseInt(splitted[0])).name(splitted[1])
                        .type(getServerType(splitted[2])).status(getServerStatus(splitted[3])).build();
                serversById.put(Integer.parseInt(splitted[0]), tmpServer);
            }

            try (BufferedReader saReader = new BufferedReader(new FileReader(sysadminCache))) {
                while ((line = saReader.readLine()) != null) {
                    String[] splitted = line.split(",");
                    
                    SystemAdministrator tmpSysadmin = new SystemAdministrator();
                    tmpSysadmin.setName(splitted[0]);
                    tmpSysadmin.setEmployeeID(Integer.parseInt(splitted[1]));
                    
                    List<Server> tmpServers = new ArrayList<>();
                    for (int i = 2; i < splitted.length; i++) {
                        tmpServers.add(serversById.get(Integer.parseInt(splitted[i])));
                    }
                    tmpSysadmin.setServers(tmpServers);
                    sysAdminList.add(tmpSysadmin);
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DefaultMultiMap<Server, SystemAdministrator> returnValue = new DefaultMultiMap<>();
        
        for (SystemAdministrator systemAdministrator : sysAdminList) {
            for (Server server : systemAdministrator.getServers()) {
                returnValue.put(server, systemAdministrator);
            }
        }
        
        return returnValue;
    }

    @Override
    public DefaultMultiMap<Server, SystemAdministrator> refresh() {
        // TODO Auto-generated method stub
        return null;
    }

    private ServerType getServerType(String string) {
        switch (string) {
        case "Linux":
            return ServerType.LINUX;
        case "LinuxWeb":
            return ServerType.LINUX_WEB;
        case "LinuxDBandWEB":
            return ServerType.LINUX_DB_AND_WEB;
        case "Win":
            return ServerType.WINDOWS;
        case "WinWeb":
            return ServerType.WINDOWS_WEB;
        case "WinDBandWEB":
            return ServerType.WINDOWS_DB_AND_WEB;
        }
        return null;
    }

    private ServerStatus getServerStatus(String string) {
        switch (string) {
        case "RUNNING":
            return ServerStatus.RUNNING;
        case "STOPPED":
            return ServerStatus.STOPPED;

        }
        return null;
    }
}
