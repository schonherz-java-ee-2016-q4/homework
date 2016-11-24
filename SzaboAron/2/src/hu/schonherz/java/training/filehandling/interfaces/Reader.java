package hu.schonherz.java.training.filehandling.interfaces;

import java.io.IOException;

public interface Reader {
    public Object next() throws IOException;
}
