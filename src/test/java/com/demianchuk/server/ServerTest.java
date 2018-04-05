package com.demianchuk.server;

import com.demianchuk.services.*;
import com.demianchuk.util.ServerUtil;
import org.junit.*;
import org.junit.jupiter.api.BeforeAll;

import java.net.*;

import static org.junit.Assert.*;

public class ServerTest {
    int port;
    ServerSocket serverSocket;
    ServerStartService serverStartService;
    ClientAcceptService clientAcceptService;
    ReaderService readerService;

    @Before
    public void setUp() {
            port = ServerUtil.getPort();
            serverStartService = new ServerStartServiceImpl();
            clientAcceptService = new ClientAcceptServiceImpl();
            startServer();
    }

    //@Test
    public void accept() {
        Socket client = clientAcceptService.accept(serverSocket);
        assertNotNull(client);
        assertEquals(port, client.getLocalPort());
    }

    @Test
    public void read() {
        Socket client = clientAcceptService.accept(serverSocket);
        assertNotNull(client);
        assertEquals(port, client.getLocalPort());
        readerService = new ReaderServiceImpl(client);
        String response = readerService.read();
        assertNotNull(response);
        System.out.println(response);
    }

    private void startServer(){
        serverSocket = serverStartService.startServer(port);
        assertNotNull(serverSocket);
        assertEquals(port, serverSocket.getLocalPort());
    }

}