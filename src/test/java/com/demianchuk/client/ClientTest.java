package com.demianchuk.client;

import com.demianchuk.server.Server;
import com.demianchuk.util.ServerUtil;
import com.demianchuk.services.*;
import org.junit.Before;
import org.junit.Test;

import java.net.*;

import static org.junit.Assert.*;


public class ClientTest {
    int port;
    String host;
    ConnectorService connectorService;

    @Before
    public void setUp() {
        port = ServerUtil.getPort();
        host = ServerUtil.getHost();
        connectorService = new ConnectorServiceImpl();
    }

    @Test
    public void connect() {
       Socket s = connectorService.connect(host, port);
       assertNotNull(s);
    }

}