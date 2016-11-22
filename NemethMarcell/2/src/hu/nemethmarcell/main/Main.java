package hu.nemethmarcell.main;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import hu.nemethmarcell.reader.ServerReader;

public class Main {
    public static List<String> list;

    public static void main(String[] args) {
        list = ServerReader.readFromTextFile();
        System.out.println(list.get(3));

        TimerTask task = (TimerTask) new FileWatcher(new File("files" + File.separator + "servers.txt")) {
            @Override
            protected void onChange(File file) {
                list = ServerReader.readFromTextFile();
                System.out.println(list.get(3));
            }
        };

        Timer timer = new Timer();

        timer.schedule(task, new Date(), 2000);
    }
}
