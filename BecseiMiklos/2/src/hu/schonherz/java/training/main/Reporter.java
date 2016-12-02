package hu.schonherz.java.training.main;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class Reporter {
	
	public static void report( List<Server> serverList , List<SystemAdministrator> adminList ) {       
	   
		List<Server> tmpList = new ArrayList<>();
        
		for ( SystemAdministrator admin : adminList) {    	       	   
    	   
    	   for ( Server server : serverList ) {
    		   if ( server.getStatus().equals(ServerStatus.STOPPED) &&
    	            admin.getServers().contains(server.getId())) {
    			   
    			    tmpList.add(server);
    		   }    		   
    	   }
    	    if ( !(tmpList.isEmpty()) ) { 
    	    	for ( Server tmp : tmpList ) {
    	    	System.out.println( tmp.getId() + " - " + 
    								tmp.getName() + " - " + tmp.getType());    	    	
    	    }    	    
    	    	tmpList.clear();	    
		    System.out.println("--------------------------------");
		    
		    System.out.println( admin.getEmployeeID() + " - " + admin.getName() );
		    
		    System.out.println("\n");
		    		    		    
    	    }    	   
       }		
	}
}