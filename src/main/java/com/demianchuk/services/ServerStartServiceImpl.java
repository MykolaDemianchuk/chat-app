package com.demianchuk.services;

import org.apache.log4j.Logger;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerStartServiceImpl implements ServerStartService {
    private static final Logger LOGGER = Logger.getLogger(ServerStartServiceImpl.class);

    @Override
    public ServerSocket startServer(int port) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e){
            LOGGER.warn(e.getMessage(), e);
        }
        return serverSocket;
    }
}
