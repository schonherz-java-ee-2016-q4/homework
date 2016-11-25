package hu.schonherz.java.training.main;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SysadminsRead {
	static List<SystemAdministrator> readFromFile() {
		List<SystemAdministrator> adminList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\files\\sysadmins.txt"));
			String line;
	    	try {
				while ((line=br.readLine())!=null){
					String[] lineElements = line.split("[ ,]");
					if ((!lineElements[0].equals("Sysadmin")) || lineElements.length<4) {
						continue;
					}
					List<Server> listOfServers = new ArrayList<>();
					for (int i = 3; i < lineElements.length; i++) {
						listOfServers.add(new Server(Integer.parseInt(lineElements[i])));
					}
					SystemAdministrator dummy = new SystemAdministrator(lineElements[1],
							Integer.parseInt(lineElements[2]), listOfServers);
					adminList.add(dummy);
				}
			} catch (IOException e) {
				System.out.println("I/O Exception");
				e.printStackTrace();
				return adminList;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			return adminList;
		}
		return adminList;
	}
	
	
}
