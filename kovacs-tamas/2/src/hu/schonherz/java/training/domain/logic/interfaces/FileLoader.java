package hu.schonherz.java.training.domain.logic.interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface FileLoader {

    enum Files {
        SERVER, ADMIN
    }

    BufferedReader getReaderForFile(Files choosenFile) throws FileNotFoundException;
}
