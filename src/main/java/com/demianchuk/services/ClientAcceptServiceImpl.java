package com.demianchuk.services;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientAcceptServiceImpl implements ClientAcceptService {
    private static final Logger LOGGER = Logger.getLogger(ClientAcceptServiceImpl.class);

    @Override
    public Socket accept(ServerSocket serverSocket) {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return socket;
    }
}
