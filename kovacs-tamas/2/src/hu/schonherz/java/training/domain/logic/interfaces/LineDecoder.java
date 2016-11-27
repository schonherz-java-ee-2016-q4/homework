package hu.schonherz.java.training.domain.logic.interfaces;

import java.util.List;
import java.util.Optional;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;

public interface LineDecoder {

    Optional<Server> convertLineToServer(String line);
    Optional<SystemAdministrator> convertLineToAdmin(String line);
    void setServers(List<Server> servers);

}
