package hu.schonherz.java.training.domain.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import hu.schonherz.java.training.domain.logic.interfaces.FileLoader;

/**
 * The role of this class is to load the needed files and return them as streams.
 */
public class SimpleFileLoader implements FileLoader {

    private static final String ROOT_FOLDER = "files";

    @Override
    public BufferedReader getReaderForFile(Files choosenFile) throws FileNotFoundException {
        String subPath;
        switch (choosenFile) {
            case SERVER: subPath = "servers.txt"; break;
            case ADMIN: subPath = "sysadmins.txt"; break;
            // Reminder in case of expanding the Files enumeration later
            default: throw new RuntimeException("Request for unknown file: " + choosenFile.name());
        }

        Path path = Paths.get(ROOT_FOLDER, subPath);
        File requestedFile = path.toFile();
        return new BufferedReader(new FileReader(requestedFile));
    }

}
