package hu.schonherz.java.training.utility.file.processor;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;
import hu.schonherz.java.training.utility.map.MultiMap;
import hu.schonherz.java.training.utility.map.MultimapImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProcessorImpl implements FileProcessor<Server, SystemAdministrator> {

    private final File serverFile;
    private final File sysAdminFile;

    public FileProcessorImpl(File serverFile, File sysadminFile) {
        this.serverFile = serverFile;
        this.sysAdminFile = sysadminFile;
    }

    @Override
    public MultiMap<Server, SystemAdministrator> process() {
        Map<Integer, Server> serversById = new HashMap<>();
        ServerBuilder serverBuilder = new ServerBuilder();

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

    private static ServerType getServerType(String string) {
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

    private static ServerStatus getServerStatus(String string) {
        switch (string) {
            case "RUNNING":
                return ServerStatus.RUNNING;
            case "STOPPED":
                return ServerStatus.STOPPED;
        }
        return null;
    }

}
