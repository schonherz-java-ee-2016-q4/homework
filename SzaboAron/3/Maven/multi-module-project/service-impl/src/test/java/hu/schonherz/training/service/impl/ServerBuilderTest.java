package hu.schonherz.training.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.schonherz.training.service.impl.domain.server.Server;
import hu.schonherz.training.service.impl.domain.server.ServerBuilder;
import hu.schonherz.training.service.impl.domain.server.ServerStatus;
import hu.schonherz.training.service.impl.domain.server.ServerType;

public class ServerBuilderTest {

    @Test
    public void testBuildServer() {
        Server testServer = new ServerBuilder(2, "testserver").type(ServerType.LINUX).status(ServerStatus.RUNNING)
                .build();
        assertEquals(2, testServer.getId());
        assertEquals("testserver", testServer.getName());
        assertEquals(ServerType.LINUX, testServer.getType());
        assertEquals(ServerStatus.RUNNING, testServer.getStatus());
        Server testServer2 = new ServerBuilder(2, "testserver").type(ServerType.LINUX).status(ServerStatus.RUNNING)
                .build();
        assertEquals(true, testServer.equals(testServer2));
        assertEquals(false, testServer.equals(null));
        testServer2.setId(3);
        assertEquals(false, testServer.equals(testServer2));
        testServer2.setId(2);
        testServer2.setName("testname");
        assertEquals(false, testServer.equals(testServer2));
        testServer2.setName("testserver");
        testServer2.setStatus(ServerStatus.STOPPED);
        assertEquals(false, testServer.equals(testServer2));
        testServer2.setStatus(ServerStatus.RUNNING);
        testServer2.setType(ServerType.LINUX_WEB);
        assertEquals(false, testServer.equals(testServer2));
        assertEquals(true, testServer.equals(testServer));
        assertEquals(false, testServer.equals(new Integer(5)));
        testServer.setName(null);
        assertEquals(false, testServer.equals(testServer2));
        testServer.setName("testserver");
        assertEquals("2 - testserver - LINUX", testServer.toString());
    }
}
