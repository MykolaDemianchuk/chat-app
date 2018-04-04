package com.demianchuk.services;

import org.junit.Test;

import java.net.ServerSocket;

import static org.junit.Assert.*;

public class ServerStartServiceImplTest {
    ServerSocket serverSocket;
    ServerStartService serverStartService = new ServerStartServiceImpl();

    @Test
    public void startServer() {
        serverSocket = serverStartService.startServer(5000);
        assertNotNull(serverSocket);
    }
}