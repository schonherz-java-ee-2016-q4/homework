package hu.schonherz.training.service.api.connector;

import java.io.IOException;

import hu.schonherz.training.service.api.multimap.MultiMap;

public interface Connector<T, K> {

    MultiMap<T, K> connect() throws IOException;
}
