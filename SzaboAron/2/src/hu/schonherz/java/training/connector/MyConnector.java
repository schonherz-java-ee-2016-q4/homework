package hu.schonherz.java.training.connector;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import hu.schonherz.java.aron9609.multimap.MultiMap;
import hu.schonherz.java.aron9609.multimap.MyMultiMap;
import hu.schonherz.java.training.connector.interfaces.Connector;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class MyConnector implements Connector {
    private final Reader serverReader;
    private final Reader systemAdministratorReader;

    public MyConnector(Reader serverReader, Reader systemAdministratorReader) {
        super();
        this.serverReader = serverReader;
        this.systemAdministratorReader = systemAdministratorReader;
    }

    @Override
    public MultiMap<Server, Employee> connect() throws IOException {
        MultiMap<Server, Employee> multimapFromStoppedServers = new MyMultiMap<>();
        List<Server> serverList = serverReader.readAll();
        List<SystemAdministrator> adminList = systemAdministratorReader.readAll();
        MyMultiMap.MultiMapNode<Server, Employee> tmp = new MyMultiMap.MultiMapNode<>();
        for (Server s : stoppedServers(serverList)) {
            tmp.setKey(s);
            for (SystemAdministrator a : adminList) {
                if (!a.getServers().stream().filter(server -> server.getId() == s.getId()).collect(Collectors.toList())
                        .isEmpty()) {
                    tmp.addValue(a);
                }
                multimapFromStoppedServers.put(tmp.getKey(), tmp.getValues());
            }
        }
        serverReader.reset();
        systemAdministratorReader.reset();
        return multimapFromStoppedServers;
    }

    private List<Server> stoppedServers(List<Server> servers) {
        return servers.stream().filter(server -> server.getStatus().equals(ServerStatus.STOPPED))
                .collect(Collectors.toList());
    }

}
