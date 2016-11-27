package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.Server.ServerBuilder;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class ServerReader {
    public ServerBuilder serverbuilder = new ServerBuilder();
    public Server dummyserver;
    public String sCurrentLine;

    public List<Server> servers = new ArrayList<>();

    public ServerReader() {

    }

    public void ServerReaderStart() {
        servers.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(".\\files\\servers.txt"))) {
            while ((sCurrentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(sCurrentLine, ",");
                try {
                    serverbuilder.id(Integer.parseInt(st.nextToken()));
                } catch (Exception e) {
                    System.out.println("Illegal ID at: " + sCurrentLine);
                    continue;
                }
                try {
                    serverbuilder.name(st.nextToken());
                } catch (Exception e) {
                    System.out.println("Illegal name at: " + sCurrentLine);
                    continue;
                }
                try {
                    serverbuilder.type(ServerType.valueOf(st.nextToken()));
                } catch (Exception e) {
                    System.out.println("Illegal type at: " + sCurrentLine);
                    continue;
                }
                try {
                    serverbuilder.status(ServerStatus.valueOf(st.nextToken()));
                } catch (Exception e) {
                    System.out.println("Illegal status at: " + sCurrentLine);
                    continue;
                }
                dummyserver = serverbuilder.build();
                servers.add(dummyserver);
            }
            br.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getClass());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Server> getServerList() {
        return servers;
    }
}
