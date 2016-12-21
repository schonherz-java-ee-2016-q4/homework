package hu.schonherz.java.training.utility.file.handler;

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
import hu.schonherz.java.training.utility.map.MultimapImpl;
import hu.schonherz.java.training.utility.map.MultiMap;

public class FileHandlerImpl implements FileHandler<Server, SystemAdministrator> {

    private final String projectDir = "project";
    private final String filesDir = "files";
    private final String serverFileName = "servers.txt";
    private final String sysAdminFileName = "sysadmins.txt";

    private final Path pathToServerFile = Paths.get("2", projectDir, filesDir, serverFileName);
    private final Path pathToSysadminFile = Paths.get("2", projectDir, filesDir, sysAdminFileName);

    private File serverFile;
    private File sysAdminFile;

    private long serverFileModDateCache;
    private long sysAdminFileModDateCache;

    public FileHandlerImpl() throws FileNotFoundException {
        serverFile = pathToServerFile.toFile();

        if (!serverFile.exists()) {
            throw new FileNotFoundException("Server file not found");
        }

        serverFileModDateCache = serverFile.lastModified();

        sysAdminFile = pathToSysadminFile.toFile();

        if (!sysAdminFile.exists()) {
            throw new FileNotFoundException("Sysadmin file not found");
        }

        sysAdminFileModDateCache = sysAdminFile.lastModified();

    }

    @Override
    public MultiMap<Server, SystemAdministrator> assemble() {

        Map<Integer, Server> serversById = new HashMap<>();
        ServerBuilder serverBuilder = new ServerBuilder();

        List<Server> serverList = new ArrayList<>();
        List<SystemAdministrator> sysAdminList = new ArrayList<>();
        

        try (BufferedReader br = new BufferedReader(new FileReader(serverFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(",");
                Server tmpServer = serverBuilder.id(Integer.parseInt(splitted[0]))
                    .name(splitted[1])
                    .type(getServerType(splitted[2]))
                    .status(getServerStatus(splitted[3]))
                    .build();
                serversById.put(Integer.parseInt(splitted[0]), tmpServer);
            }

            try (BufferedReader saReader = new BufferedReader(new FileReader(sysAdminFile))) {
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
        MultimapImpl<Server, SystemAdministrator> returnValue = new MultimapImpl<>();

        for (SystemAdministrator systemAdministrator : sysAdminList) {
            for (Server server : systemAdministrator.getServers()) {
                returnValue.put(server, systemAdministrator);
            }
        }

        return returnValue;
    }

    @Override
    public MultiMap<Server, SystemAdministrator> refresh(MultiMap<Server, SystemAdministrator> multiMap) {

        boolean serverFileModified = sysAdminFileModDateCache != sysAdminFile.lastModified();
        boolean sysAdminFileModified = serverFileModDateCache != serverFile.lastModified();

        if (serverFileModified || sysAdminFileModified) {
            sysAdminFileModDateCache = sysAdminFile.lastModified();
            serverFileModDateCache = serverFile.lastModified();
            System.out.println("File modified");
            return assemble();
        }

        return multiMap;
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
