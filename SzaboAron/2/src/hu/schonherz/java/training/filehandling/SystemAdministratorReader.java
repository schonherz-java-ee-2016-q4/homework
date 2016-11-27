package hu.schonherz.java.training.filehandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class SystemAdministratorReader implements Reader<SystemAdministrator> {
    private final Path path;
    private final BufferedReader br;
    private final FileInputStream fis;

    public SystemAdministratorReader(Path path) throws IOException {
        super();
        this.path = path;
        fis = new FileInputStream(path.toFile());
        br = new BufferedReader(new InputStreamReader(fis));
    }

    @Override
    public SystemAdministrator next() throws IOException {
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

    @Override
    public List<SystemAdministrator> readAll() throws IOException {
        List<SystemAdministrator> adminList = new ArrayList<>();
        SystemAdministrator tmpAdmin = (SystemAdministrator) this.next();
        while (tmpAdmin != null) {
            adminList.add(tmpAdmin);
            tmpAdmin = (SystemAdministrator) this.next();
        }
        return adminList;
    }

    @Override
    public void reset() throws IOException {
        fis.getChannel().position(0);

    }

    @Override
    public void close() throws IOException {
        br.close();
    }

}
