package hu.schonherz.java.training.main;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import hu.schonherz.java.training.domain.people.AdminReader;
import hu.schonherz.java.training.domain.server.ServerReader;

public class Main {

    public static void main(String... args) {
        
    	Reporter.report( ServerReader.readFile(), AdminReader.readFile() );
    	TimerTask task = new FileWatcher(new File("files/servers.txt")) {
    		
    		protected void onChange(File file) {
    		Reporter.report( ServerReader.readFile(), AdminReader.readFile() );
    		}
        };
        
Timer timer = new Timer();
timer.schedule(task, new Date(), 2000);


    }
}