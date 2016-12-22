package hu.schonherz.java.training.utility.file.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerBuilder;

public class ServerFileReader implements FileProcessor<Server>{

    @Override
    public List<Server> read(File file) {
        List<Server> serverList = new ArrayList<>();
        
        ServerBuilder serverBuilder = new ServerBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(",");
                Server tmpServer = serverBuilder.id(Integer.parseInt(splitted[0]))
                    .name(splitted[1])
                    .type(getServerType(splitted[2]))
                    .status(getServerStatus(splitted[3]))
                    .build();
                serverList.add(tmpServer);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return serverList;
    }

}
