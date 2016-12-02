package hu.schonherz.java.training.main;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;

public class Connecter {

    public Connecter() {

    }

    public List<SystemAdministrator> Connect(int id, SysAdminReader adminReader) {
        List<SystemAdministrator> serveradmins = new ArrayList<>();
        serveradmins.clear();

        for (SystemAdministrator dummyadmin : adminReader.getAdmins()) {
            try {
                if (contain(dummyadmin.getServers(), id))
                    serveradmins.add(dummyadmin);
            } catch (Exception e) {
                continue;
            }
        }
        return serveradmins;
    }

    public boolean contain(List<Server> serverList, int id) {
        for (Server dummyserver : serverList) {
            if (dummyserver.getId() == id)
                return true;
        }
        return false;
    }

}
