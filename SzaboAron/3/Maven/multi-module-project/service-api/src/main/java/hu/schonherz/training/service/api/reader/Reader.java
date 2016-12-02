package hu.schonherz.training.service.api.reader;

import java.io.IOException;
import java.util.List;

public interface Reader<T> {
    public T next() throws IOException;

    public List<T> readAll() throws IOException;

    public void reset() throws IOException;

    public void close();
}
