package hu.schonherz.java.training.domain.logic.interfaces;

import com.gmail.kovtamas1991.collections.MultiMap;

import hu.schonherz.java.training.domain.logic.FileParseException;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;

public interface FileParser {

    MultiMap<Server, Employee> ReadStoppedServersAndTheirAdmins() throws FileParseException;

}
