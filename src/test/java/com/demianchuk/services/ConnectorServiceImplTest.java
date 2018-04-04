package com.demianchuk.services;

import org.junit.Test;

import java.net.Socket;

import static org.junit.Assert.*;

public class ConnectorServiceImplTest {
    ConnectorService connectorService = new ConnectorServiceImpl();

    @Test
    public void connect() {
        Socket s = connectorService.connect("127.0.0.1", 5000);
        assertNotNull(s);
    }
}