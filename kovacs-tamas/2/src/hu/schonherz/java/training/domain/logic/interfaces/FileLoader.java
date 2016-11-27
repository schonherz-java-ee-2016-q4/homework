package hu.schonherz.java.training.domain.logic.interfaces;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import hu.schonherz.java.training.domain.logic.Files;

public interface FileLoader {

    BufferedReader getReaderForFile(Files choosenFile) throws FileNotFoundException;

}
