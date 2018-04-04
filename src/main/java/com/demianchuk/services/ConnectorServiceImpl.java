package com.demianchuk.services;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.Socket;

public class ConnectorServiceImpl implements ConnectorService {
    private static final Logger LOGGER = Logger.getLogger(ConnectorServiceImpl.class);

    @Override
    public Socket connect(String host, int port) {
        Socket socket = null;
        try {
            socket =  new Socket(host, port);
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return socket;
    }
}
