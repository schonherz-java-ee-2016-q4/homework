package hu.schonherz.java.training.main;

import hu.schonherz.java.training.domain.impl.LogPrinter;

public class Main {

    public static void main(final String... args) throws Exception {
        LogPrinter logPrinter = new LogPrinter();
        Thread logThread = new Thread(logPrinter);
        logThread.start();

        System.in.read();
        System.out.println("Safely stopping log thread...");
        logPrinter.stop();
    }

}
