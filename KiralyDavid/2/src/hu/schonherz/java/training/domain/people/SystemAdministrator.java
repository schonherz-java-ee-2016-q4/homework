package hu.schonherz.java.training.domain.people;

import java.util.List;

public class SystemAdministrator extends Employee {
    private static final long serialVersionUID = 2244059719140625986L;

    private List<Integer> servers;

    public SystemAdministrator(String name, int employeeID, List<Integer> servers) {
        super(name, employeeID);
        this.servers = servers;
    }

    public List<Integer> getServers() {
        return servers;
    }

    public void setServers(final List<Integer> servers) {
        this.servers = servers;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((servers == null) ? 0 : servers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
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