package hu.schonherz.java.training.main;

import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;

public class Reporter {
	
	public static void report( List<Server> server_list , List<SystemAdministrator> admin_list ) {
for ( int i = 0; i < 4; i++ ) {
          if (server_list.get(i).getStatus().equals(ServerStatus.STOPPED)) 
          {
              System.out.println(server_list.get(i).getId() + " - " + 
              server_list.get(i).getName() + " - " + server_list.get(i).getType());
          }
      }
       System.out.println("--------------------------------");
      for ( int i = 0; i < 3; i++ ) {
          if (server_list.get(i).getStatus().equals(ServerStatus.STOPPED)) 
          {
              if (admin_list.get(i).getServers().contains(server_list.get(i).getId())) 
              {
                  System.out.println(admin_list.get(i).getEmployeeID() +
                  " - " + admin_list.get(i).getName());
              }
          }
      }
		
	}
}