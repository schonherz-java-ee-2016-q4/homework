package hu.schonherz.java.training.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.schonherz.java.training.domain.people.SystemAdministrator;

public class AdminReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	public static List<SystemAdministrator> read() {

		List<SystemAdministrator> result = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}
				String[] attributes = line.split(",");

				List<Integer> list = new ArrayList<>();
				Map<String, List<Integer>> map = new HashMap<>();
				for (int i = 2; i < attributes.length; i++) {
					list.add(Integer.parseInt(attributes[i]));
				}
				map.put(attributes[0], list);
				SystemAdministrator admin = new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]),
						map.get(attributes[0]));

				result.add(admin);
			}
		} catch (IOException e) {
			System.out.println("io error");
		}
		return result;
	}
}