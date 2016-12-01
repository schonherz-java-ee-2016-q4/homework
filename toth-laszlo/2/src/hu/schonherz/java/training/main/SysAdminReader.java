package hu.schonherz.java.training.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.people.SystemAdministrator.SysAdminBuilder;
import hu.schonherz.java.training.domain.server.Server;

public class SysAdminReader {

    public SystemAdministrator dummyadmin = new SystemAdministrator();

    public List<SystemAdministrator> admins = new ArrayList<>();

    public String sCurrentLine;

    public SysAdminBuilder adminbuilder = new SysAdminBuilder();

    public SysAdminReader() {
    }

    public void SysAdminReaderStart(List<Server> servers) {
        admins.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(".\\files\\sysadmins.txt"))) {
            while ((sCurrentLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(sCurrentLine, ",");

                try {
                    adminbuilder.name(st.nextToken());
                } catch (Exception e) {
                    System.out.println("Illegal name at: " + sCurrentLine);
                    continue;
                }
                try {
                    adminbuilder.id(Integer.parseInt(st.nextToken()));
                } catch (Exception e) {
                    System.out.println("Illegal id at: " + sCurrentLine);
                    continue;
                }
                while (st.hasMoreTokens()) {
                    try {
                        adminbuilder.ListAdd(getServerbyId(servers, Integer.parseInt(st.nextToken())));
                    } catch (Exception e) {
                        System.out.println("Illegal server id at: " + sCurrentLine);
                        continue;
                    }
                }
                dummyadmin = adminbuilder.build();
                admins.add(dummyadmin);
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public List<SystemAdministrator> getAdmins() {
        return admins;
    }

    public Server getServerbyId(List<Server> serverlist, int serverId) {
        for (Server seged : serverlist) {
            if (seged.getId() == serverId)
                return seged;
        }
        return null;
    }
}
