package hu.schonherz.java.training.filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class SystemAdministratorReader implements Reader<SystemAdministrator> {
    private final File file;
    private final BufferedReader br;
    private final FileInputStream fis;

    public SystemAdministratorReader(File file) throws IOException {
        super();
        this.file = file;
        if (file.isDirectory()) {
            throw new IllegalArgumentException("It's not a file, It's a directory");
        }
        fis = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fis));
    }

    @Override
    public SystemAdministrator next() throws IOException {
        SystemAdministrator sysAdmin = new SystemAdministrator();
        try {
            String line;
            line = br.readLine();
            while ("".equals(line)) {
                line = br.readLine();
            }
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
            sysAdmin.setName(tokens[0]);
            sysAdmin.setEmployeeID(Integer.parseInt(tokens[1]));
            sysAdmin.setServers(serverList);

        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            throw new FilerException("The specified file is incorrect");
        }
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
    public void close() {
        try {
            br.close();
        } catch (IOException e) {
            System.err.println("Can't close the file");
        }
    }

}
