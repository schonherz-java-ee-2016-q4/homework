package hu.schonherz.java.training.main;

import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class ServerRunning implements Runnable {
	private Thread serverThread = null;
	
	//Programszál létrehozása
	public void start() {
		if(serverThread == null) {
			serverThread = new Thread(this, "Server");
			serverThread.start();
		}
	}
	
	//Programszál elindítása
	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		while(serverThread == myThread) {
			result();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {}
		}
		
	}
	
	//Programszál leállítása
	public void stop() {
		serverThread = null;
	}

	public void result() {
		List<Server> serverLista = new LinkedList<Server>();
    	List<SystemAdministrator> systemAdministratorLista = new LinkedList<SystemAdministrator>();
    	serverLista = ServerReader.readFromServerFile();
    	systemAdministratorLista = ServerReader.readFromSysAdminsFile(serverLista);
    	
    	for(Server s : serverLista) {
    		if(s.getStatus() == ServerStatus.STOPPED) {
    			System.out.println(s.getId()+" - "+s.getName()+" - "+s.getType());
    			for(SystemAdministrator sa : systemAdministratorLista) {
    				for(Server sl : sa.getServers()) {
	    				if(sl.getId() == s.getId()) {
	    					System.out.println(sa.getEmployeeID()+" - "+sa.getName());
	    				}
    				}
    			}
    		}
    	}
	}
}
