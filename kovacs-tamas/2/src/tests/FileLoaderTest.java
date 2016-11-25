package tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import hu.schonherz.java.training.domain.logic.Files;
import hu.schonherz.java.training.domain.logic.SimpleFileLoader;
import hu.schonherz.java.training.domain.logic.interfaces.FileLoader;

public class FileLoaderTest {

    FileLoader fileLoader;

    @Before
    public void setUp() {
        fileLoader = new SimpleFileLoader();
    }

    @Test
    public void testServerFileLoading() throws FileNotFoundException, IOException {
        try (BufferedReader serReader = fileLoader.getReaderForFile(Files.SERVER)) {
            System.out.println("----- Contens of server file -----");
            String line;
            while ((line = serReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    @Test
    public void testAdminFileLoading() throws FileNotFoundException, IOException {
        try (BufferedReader adminReader = fileLoader.getReaderForFile(Files.ADMIN)) {
            System.out.println("----- Contens of admin file -----");
            String line;
            while ((line = adminReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
