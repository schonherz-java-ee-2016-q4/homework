package hu.nemethmarcell.domain.people;

import java.util.List;

import hu.nemethmarcell.domain.server.Server;

public class SystemAdministrator extends Employee {
    private static final long serialVersionUID = 2244059719140625986L;

    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(final List<Server> servers) {
        this.servers = servers;
    }

}