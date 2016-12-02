package hu.schonherz.java.training.main;

import java.io.File;
import java.io.IOException;

import hu.schonherz.java.training.runnable.Lister;

public class Main {

    public static void main(final String... args) throws IOException {
        File serverFile = new File("files" + File.separator + "servers.txt");
        File adminFile = new File("files" + File.separator + "sysadmins.txt");
        Lister execute = new Lister(serverFile, adminFile);
        Thread parserThread = new Thread(execute);
        parserThread.start();

        System.in.read();
        parserThread.stop();

    }
}
