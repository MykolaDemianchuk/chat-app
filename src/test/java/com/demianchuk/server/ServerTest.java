package com.demianchuk.server;

import com.demianchuk.services.*;
import com.demianchuk.util.ServerUtil;
import org.junit.*;

import java.net.*;

import static org.junit.Assert.*;

public class ServerTest {
    int port;
    ServerSocket serverSocket;
    ServerStartService serverStartService;
    ClientAcceptService clientAcceptService;

    @Before
    public void setUp() {
        port = ServerUtil.getPort();
        serverStartService = new ServerStartServiceImpl();
        clientAcceptService = new ClientAcceptServiceImpl();
        startServer();
    }

    @Test
    public void accept() {
        Socket client = clientAcceptService.accept(serverSocket);
        assertNotNull(client);
        assertEquals(port, client.getLocalPort());
    }

    private void startServer(){
        serverSocket = serverStartService.startServer(port);
        assertNotNull(serverSocket);
        assertEquals(port, serverSocket.getLocalPort());
    }

}