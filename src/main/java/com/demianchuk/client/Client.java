package com.demianchuk.client;

import com.demianchuk.services.ConnectorService;
import com.demianchuk.services.ConnectorServiceImpl;
import com.demianchuk.services.WriterService;
import com.demianchuk.services.WriterServiceImpl;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final Logger LOGGER = Logger.getLogger(Client.class);

    public static void main(String[] args) {
        Socket s = new ConnectorServiceImpl().connect("127.0.0.1", 5000);
        new WriterServiceImpl(s).write("HELLO SERVER");

        try {
            s.close();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }
}

