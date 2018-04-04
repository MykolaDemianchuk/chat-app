package com.demianchuk.services;

import org.junit.Before;
import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.*;

public class ClientAcceptServiceImplTest {
    final int port = 5000;
    ServerSocket serverSocket;
    ServerStartService serverStartService = new ServerStartServiceImpl();
    ClientAcceptService clientAcceptService = new ClientAcceptServiceImpl();

    @Before
    public void setUp() {
        serverSocket = serverStartService.startServer(port);
        assertNotNull(serverSocket);
    }
    
    @Test
    public void accept() {
        Socket socket = clientAcceptService.accept(serverSocket);
        assertNotNull(socket);
        assertEquals(port, socket.getLocalPort());
    }
}