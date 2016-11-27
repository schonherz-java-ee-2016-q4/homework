package hu.schonherz.java.training.domain.api;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

public interface FileLoader {

    BufferedReader getReaderForFile(Files choosenFile) throws FileNotFoundException;

}
