package hu.schonherz.java.training.domain.people;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.server.Server;

public class SystemAdministrator extends Employee {
    private static final long serialVersionUID = 2244059719140625986L;

    private List<Server> servers;

    public SystemAdministrator() {

    }

    public SystemAdministrator(SysAdminBuilder SysAdmin) {
        this.name = SysAdmin.name;
        this.employeeID = SysAdmin.id;
        this.servers = new ArrayList<Server>(SysAdmin.servers);
    }

    public SystemAdministrator(String name, int id) {
        this.name = name;
        this.employeeID = id;

    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(final List<Server> servers) {
        this.servers = servers;
    }

    public static class SysAdminBuilder {
        private String name;
        private int id;
        private List<Server> servers = new ArrayList<>();

        public SysAdminBuilder() {
        }

        public SysAdminBuilder name(String name) {
            this.name = name;
            return this;
        }

        public SysAdminBuilder id(int id) {
            this.id = id;
            return this;
        }

        public SysAdminBuilder ListAdd(Server server) {
            servers.add(server);
            return this;
        }

        public SystemAdministrator build() {
            SystemAdministrator SysAdmin = new SystemAdministrator(this);
            servers.clear();
            return SysAdmin;
        }
    }
}
