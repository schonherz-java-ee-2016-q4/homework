package nemethmarcell.domain.people;

/**
 * Created by Marci on 2016. 11. 22..
 */

import java.util.List;

public class SystemAdministrator extends Employee {
    private static final long serialVersionUID = 2244059719140625986L;

    public SystemAdministrator(String name, int employeeID, List<Integer> servers) {
        super(name, employeeID);
        this.servers = servers;
    }

    private List<Integer> servers;

    public List<Integer> getServers() {
        return servers;
    }

    public void setServers(final List<Integer> servers) {
        this.servers = servers;
    }

}