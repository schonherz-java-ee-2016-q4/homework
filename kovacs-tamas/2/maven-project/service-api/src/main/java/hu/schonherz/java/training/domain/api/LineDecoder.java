package hu.schonherz.java.training.domain.api;

import java.util.List;
import java.util.Optional;

import hu.schonherz.java.training.domain.dao.people.SystemAdministrator;
import hu.schonherz.java.training.domain.dao.server.Server;

public interface LineDecoder {

    Optional<Server> convertLineToServer(String line);
    Optional<SystemAdministrator> convertLineToAdmin(String line);
    void setServers(List<Server> servers);

}
