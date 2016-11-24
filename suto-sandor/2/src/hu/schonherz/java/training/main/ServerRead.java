package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

class ServerRead {
	static List<Server> readFromFile() {
		List<Server> serverList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\files\\servers.txt"));
			String line;
	    	try {
				while ((line=br.readLine())!=null){
					String[] lineElements = line.split(",");
					if (lineElements.length!=4) {
						continue;
					}
					Server dummy = Server.builder()
			                .id(Integer.parseInt(lineElements[0]))
			                .name(lineElements[1])
			                .type(ServerType.valueOf(lineElements[2].toUpperCase()))
			                .status(ServerStatus.valueOf(lineElements[3].toUpperCase()))
			                .build();

					serverList.add(dummy);
				}
			} catch (IOException e) {
				System.out.println("I/O Exception");
				e.printStackTrace();
				return serverList;
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
			return serverList;
		}
		return serverList;
	}
}
