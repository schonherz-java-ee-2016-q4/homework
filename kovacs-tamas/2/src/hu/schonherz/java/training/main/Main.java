package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import hu.schonherz.java.training.domain.logic.SimpleFileLoader;
import hu.schonherz.java.training.domain.logic.interfaces.FileLoader;

public class Main {

    public static void main(final String... args) {
        // 1. create Runnable
        // 2. create thread and start it (daemon thread)
        // 3. wait for user input
        // 4. exit on receiving any user input

        FileLoader fileLoader = new SimpleFileLoader();
        BufferedReader reader = null;
        try {
            reader = fileLoader.getReaderForFile(FileLoader.Files.ADMIN);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (reader == null) {
            System.err.println("Input stream is nul!");
            return;
        }

        System.out.println("not null!");


        try {
            reader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
