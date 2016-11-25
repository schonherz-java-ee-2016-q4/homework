package hu.schonherz.java.training.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class SystemAdministratorReader implements Reader {
    private final Path path;
    private final BufferedReader br;

    public SystemAdministratorReader(Path path) throws FileNotFoundException {
        super();
        this.path = path;
        br = new BufferedReader(new FileReader(path.toFile()));
    }

    @Override
    public Object next() throws IOException {
        String line = br.readLine();
        if (line == null) {
            return null;
        }
        String[] tokens = line.split(",");
        List<Server> serverList = new ArrayList<>();
        Server tmpServer;
        for (int i = 2; i < tokens.length; i++) {
            tmpServer = new Server();
            tmpServer.setId(Integer.parseInt(tokens[i]));
            serverList.add(tmpServer);
        }
        SystemAdministrator sysAdmin = new SystemAdministrator();
        sysAdmin.setName(tokens[0]);
        sysAdmin.setEmployeeID(Integer.parseInt(tokens[1]));
        sysAdmin.setServers(serverList);
        return sysAdmin;

    }

}
