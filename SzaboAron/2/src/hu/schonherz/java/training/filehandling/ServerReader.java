package hu.schonherz.java.training.filehandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import hu.schonherz.java.training.domain.server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;
import hu.schonherz.java.training.filehandling.interfaces.Reader;

public class ServerReader implements Reader {
    private final Path path;
    private final BufferedReader br;

    public ServerReader(Path path) throws FileNotFoundException {
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
        return new ServerBuilder(Integer.parseInt(tokens[0]), tokens[1]).type(ServerType.valueOf(tokens[2]))
                .status(ServerStatus.valueOf(tokens[3])).build();
    }

}
