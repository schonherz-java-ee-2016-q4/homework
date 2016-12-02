package hu.schonherz.training.service.impl.connectorimpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import hu.schonherz.training.service.api.connector.Connector;
import hu.schonherz.training.service.api.multimap.MultiMap;
import hu.schonherz.training.service.api.reader.Reader;
import hu.schonherz.training.service.impl.domain.people.Employee;
import hu.schonherz.training.service.impl.domain.people.SystemAdministrator;
import hu.schonherz.training.service.impl.domain.server.Server;
import hu.schonherz.training.service.impl.domain.server.ServerStatus;
import hu.schonherz.training.service.impl.multimapImpl.MyMultiMap;

public class MyConnector implements Connector<Server, Employee> {
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
                if (tmp.getKey() != null && tmp.getValues() != null && tmp.getValues().size() != 0) {
                    multimapFromStoppedServers.put(tmp.getKey(), tmp.getValues());
                }
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
