package hu.schonherz.training.service.impl.domain.people;

import java.util.List;

import hu.schonherz.training.service.impl.domain.server.Server;

public class SystemAdministrator extends Employee {
    private static final long serialVersionUID = 2244059719140625986L;

    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(final List<Server> servers) {
        this.servers = servers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((servers == null) ? 0 : servers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SystemAdministrator other = (SystemAdministrator) obj;
        if (servers == null) {
            if (other.servers != null)
                return false;
        } else if (!servers.equals(other.servers))
            return false;
        return true;
    }
}