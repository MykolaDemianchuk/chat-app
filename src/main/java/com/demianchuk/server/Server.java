package com.demianchuk.server;

import com.demianchuk.services.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class);

    public static void main(String[] args) {
        ServerSocket ss = new ServerStartServiceImpl().startServer(5000);
        Socket s = new ClientAcceptServiceImpl().accept(ss);
        String msg = null;
        try {
            msg = new ReaderServiceImpl(s.getInputStream()).read();
            ss.close();
            s.close();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        System.out.println(msg);
    }
}

