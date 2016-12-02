package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class ServerReader {
	//servers.txt fájl feldolgozása
    public static List<Server> readFromServerFile () {
    	List<Server> serverList = new LinkedList<Server>();
    	BufferedReader serverFile = null;
    	try {
			serverFile = new BufferedReader(new FileReader("files/servers.txt"));
			//System.out.println("File found.");
			String line;
			while ((line = serverFile.readLine()) != null) {
				String[] data = line.split(",");
				Server server = new Server();
				server.setId(Integer.parseInt(data[0]));
				server.setName(data[1]);
				server.setType(convert(data[2]));
				server.setStatus(ServerStatus.valueOf(data[3]));
				serverList.add(server);
			}
		} catch (FileNotFoundException e) {
			//System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("File reading faild.");
    	} finally {
			try {
				serverFile.close();
				//System.out.println("File closing is success.");
			} catch (IOException e) {
				System.out.println("File closing is faild.");
			}
		}
    	return serverList;
    }
    
    //Ez csak a jelenlegi servers.txt állományra működik. Ki kell egészíteni a többivel, illetve kellene még egy kivétel, ha nem jó szerver típust adtak meg a fájlban.
    public static ServerType convert (String s) {
    	ServerType result = null;
    	
    		switch(s) {
    		case "Win": result=ServerType.WINDOWS; break;
    		case "LinuxWeb": result=ServerType.LINUX_WEB; break;
    		case "LinuxDBandWEB": result=ServerType.LINUX_DB_AND_WEB; break;
    		default: result=null; break;
    		}
    	return result;
    }
    
    //sysadmins.txt fájl feldolgozása
    public static List<SystemAdministrator> readFromSysAdminsFile (List<Server> serverList) {
    	List<SystemAdministrator> systemAdministratorList = new LinkedList<SystemAdministrator>();
		
    	BufferedReader sysAdminsFile = null;
    	try {
    		sysAdminsFile = new BufferedReader(new FileReader("files/sysadmins.txt"));
			//System.out.println("File found.");
			String line;
			while ((line = sysAdminsFile.readLine()) != null) {
				String[] data = line.split(",");
				SystemAdministrator systemAdministrator = new SystemAdministrator();
				systemAdministrator.setName(data[0]);
				systemAdministrator.setEmployeeID(Integer.parseInt(data[1]));
				List<Server> l = new LinkedList<Server>();
				for(int i=2; i<data.length; i++) {
					for(Server s : serverList) {
						if(s.getId() == Integer.parseInt(data[i])) {
							l.add(s);
						}
					}
				}
				
				systemAdministrator.setServers(l);
				systemAdministratorList.add(systemAdministrator);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("File reading faild.");
    	} finally {
			try {
				sysAdminsFile.close();
				//System.out.println("File closing is success.");
			} catch (IOException e) {
				System.out.println("File closing is faild.");
			}
		}
    	return systemAdministratorList;
    }
}
