package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import hu.schonherz.java.training.domain.logic.SimpleLineDecoder;
import hu.schonherz.java.training.domain.logic.interfaces.LineDecoder;
import hu.schonherz.java.training.domain.people.SystemAdministrator;
import hu.schonherz.java.training.domain.server.Server;
import hu.schonherz.java.training.domain.server.ServerStatus;
import hu.schonherz.java.training.domain.server.ServerType;

public class LineDecoderTest {

    private LineDecoder lnDecoder;

    @Before
    public void setUp() {
        lnDecoder = new SimpleLineDecoder();
    }

    @Test
    public void testServerDecoding() {
        String line1 = "2,WEB01,Win,RUNNING";
        String line2 = "3,SQLNWEB01,LinuxDBandWEB,STOPPED";
        String line3 = "-4,WEB02,LinuxWebStuff,SLEEPING";
        Server expectedSer1 = Server.builder().id(2).name("WEB01").type(ServerType.WINDOWS).status(ServerStatus.RUNNING).build();
        Server expectedSer2 = Server.builder().id(3).name("SQLNWEB01").type(ServerType.LINUX_DB_AND_WEB).status(ServerStatus.STOPPED).build();


        Optional<Server> actualSerOpt1 = lnDecoder.convertLineToServer(line1);
        Optional<Server> actualSerOpt2 = lnDecoder.convertLineToServer(line2);
        Optional<Server> actualSerOpt3 = lnDecoder.convertLineToServer(line3);

        assertTrue(actualSerOpt1.isPresent());
        assertTrue(actualSerOpt2.isPresent());
        assertFalse(actualSerOpt3.isPresent());

        assertEquals(expectedSer1, actualSerOpt1.get());
        assertEquals(expectedSer2, actualSerOpt2.get());
    }

    @Test
    public void testAdminDecoding() {
        List<Server> dummyServers = createDummyServers();
        lnDecoder.setServers(dummyServers);

        String line1 = "Sysadmin Ian,324,3,4";
        String line2 = "Sysadmin John,354,1,2";
        String line3 = "Sysadmin Ken,38f7,k3,k4";

        SystemAdministrator expectedAdmin1 = new SystemAdministrator();
        expectedAdmin1.setEmployeeID(324);
        expectedAdmin1.setName("Sysadmin Ian");
        expectedAdmin1.setServers(Arrays.asList(dummyServers.get(3), dummyServers.get(4)));

        SystemAdministrator expectedAdmin2 = new SystemAdministrator();
        expectedAdmin2.setEmployeeID(354);
        expectedAdmin2.setName("Sysadmin John");
        expectedAdmin2.setServers(Arrays.asList(dummyServers.get(1), dummyServers.get(2)));

        Optional<SystemAdministrator> actualAdminOpt1 = lnDecoder.convertLineToAdmin(line1);
        Optional<SystemAdministrator> actualAdminOpt2 = lnDecoder.convertLineToAdmin(line2);
        Optional<SystemAdministrator> actualAdminOpt3 = lnDecoder.convertLineToAdmin(line3);

        assertTrue(actualAdminOpt1.isPresent());
        assertTrue(actualAdminOpt2.isPresent());
        assertFalse(actualAdminOpt3.isPresent());

        assertEquals(expectedAdmin1, actualAdminOpt1.get());
        assertEquals(expectedAdmin2, actualAdminOpt2.get());
    }

    private List<Server> createDummyServers() {
        List<Server> dummyServers = new ArrayList<>();
        ServerType[] types = {ServerType.LINUX, ServerType.LINUX_WEB, ServerType.LINUX_DB_AND_WEB,
                ServerType.WINDOWS, ServerType.WINDOWS_WEB, ServerType.WINDOWS_DB_AND_WEB};
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int id = i;
            String name = "SomeName" + i;
            ServerType type = types[rnd.nextInt(types.length)];
            ServerStatus status = (rnd.nextBoolean()) ? ServerStatus.RUNNING : ServerStatus.STOPPED;

            Server ser = Server.builder().id(id).name(name).type(type).status(status).build();
            dummyServers.add(ser);
        }

        return dummyServers;
    }
}
