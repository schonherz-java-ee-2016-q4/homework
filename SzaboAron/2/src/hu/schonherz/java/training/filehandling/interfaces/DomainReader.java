package hu.schonherz.java.training.filehandling.interfaces;

import java.io.IOException;

public interface DomainReader {
    public Object next() throws IOException;
}
