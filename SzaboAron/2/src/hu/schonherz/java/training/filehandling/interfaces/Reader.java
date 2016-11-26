package hu.schonherz.java.training.filehandling.interfaces;

import java.io.IOException;
import java.util.List;

public interface Reader<T> {
    public Object next() throws IOException;

    public List<T> readAll() throws IOException;

    public void reset() throws IOException;

    public void close() throws IOException;
}
