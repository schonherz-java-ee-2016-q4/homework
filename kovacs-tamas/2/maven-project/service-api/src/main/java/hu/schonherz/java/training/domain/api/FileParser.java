package hu.schonherz.java.training.domain.api;

import hu.schonherz.java.training.domain.collections.MultiMap;
import hu.schonherz.java.training.domain.dao.people.Employee;
import hu.schonherz.java.training.domain.dao.server.Server;

public interface FileParser {

    MultiMap<Server, Employee> getStoppedServersAndTheirAdmins() throws FileParseException;

}
