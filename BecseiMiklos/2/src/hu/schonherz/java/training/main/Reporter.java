package hu.schonherz.java.training.main;

import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class Reporter {
	
	public static void report( List<Server> serverlist , List<SystemAdministrator> adminlist ) {
for ( int i = 0; i < 4; i++ ) {
          if (serverlist.get(i).getStatus().equals(ServerStatus.STOPPED)) 
          {
              System.out.println(serverlist.get(i).getId() + " - " + 
              serverlist.get(i).getName() + " - " + serverlist.get(i).getType());
          }
      }
       System.out.println("--------------------------------");
      for ( int i = 0; i < 3; i++ ) {
          if (serverlist.get(i).getStatus().equals(ServerStatus.STOPPED)) 
          {
              if (adminlist.get(i).getServers().contains(serverlist.get(i).getId())) 
              {
                  System.out.println(adminlist.get(i).getEmployeeID() +
                  " - " + adminlist.get(i).getName());
              }
          }
      }
		
	}
}