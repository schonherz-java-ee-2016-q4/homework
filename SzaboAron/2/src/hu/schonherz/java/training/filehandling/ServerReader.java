package hu.schonherz.java.training.filehandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.processing.FilerException;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class ServerReader implements Reader<Server> {
    private final Path path;
    private final BufferedReader br;
    private final FileInputStream fis;

    public ServerReader(Path path) throws IOException {
        super();
        this.path = path;
        if (path.toFile().isDirectory()) {
            throw new IllegalArgumentException("It's not a file, It's a directory");
        }
        fis = new FileInputStream(path.toFile());
        br = new BufferedReader(new InputStreamReader(fis));
    }

    @Override
    public Server next() throws IOException {
        String line;
        try {
            line = br.readLine();
            if (line == null) {
                return null;
            }
            ServerType t;
            String[] tokens = line.split(",");
            return new ServerBuilder(Integer.parseInt(tokens[0]), tokens[1])
                    .type(ServerType.valueOf(tokens[2].toUpperCase())).status(ServerStatus.valueOf(tokens[3])).build();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            throw new FilerException("The specified file is incorrect");
        }
    }

    @Override
    public List<Server> readAll() throws IOException {
        List<Server> serverList = new ArrayList<>();
        Server tmpServer = (Server) this.next();
        while (tmpServer != null) {
            serverList.add(tmpServer);
            tmpServer = (Server) this.next();
        }
        return serverList;
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
