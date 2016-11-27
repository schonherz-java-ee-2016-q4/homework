package hu.schonherz.java.training.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import hu.schonherz.java.training.runnable.Lister;

public class Main {

    public static void main(final String... args) throws IOException {
        Lister execute = new Lister(Paths.get("files" + File.separator + "servers.txt"),
                Paths.get("files" + File.separator + "sysadmins.txt"));
        Thread parserThread = new Thread(execute);
        parserThread.start();

        System.in.read();
        parserThread.stop();

    }
}
