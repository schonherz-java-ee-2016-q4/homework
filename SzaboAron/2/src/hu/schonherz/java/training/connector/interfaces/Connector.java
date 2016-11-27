package hu.schonherz.java.training.connector.interfaces;

import java.io.IOException;

import hu.schonherz.java.aron9609.multimap.MultiMap;
import hu.schonherz.java.training.domain.people.Employee;
import hu.schonherz.java.training.domain.server.Server;

public interface Connector {

    MultiMap<Server, Employee> connect() throws IOException;
}
