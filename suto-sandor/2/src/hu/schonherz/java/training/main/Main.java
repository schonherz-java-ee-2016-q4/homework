package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import hu.schonherz.java.training.domain.*;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.*;

public class Main {
	public static void main(final String... args) {
		try {
			do {
				List<Server> servers = ServerRead.readFromFile();
				List<SystemAdministrator> admins = SysadminsRead.readFromFile();

				for (Server serverIt : servers) {
					if (serverIt.getStatus().equals(ServerStatus.STOPPED)) {
						System.out.println(serverIt.getId() + " - " + serverIt.getName() + " - " + serverIt.getType());
						System.out.println("--------------------------------");
						for (SystemAdministrator sysAdm : admins) {
							for (int j = 0; j < sysAdm.getServers().size(); j++) {
								if (sysAdm.getServers().get(j).getId() == serverIt.getId()) {
									System.out.println(sysAdm.getEmployeeID() + " - " + sysAdm.getName());
								}
							}
						}
					}
				}
				
				Thread.sleep(2000);
			} while (true);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

