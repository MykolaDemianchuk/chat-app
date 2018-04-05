package com.demianchuk.services;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReaderServiceImpl implements ReaderService {
    private static final Logger LOGGER = Logger.getLogger(ReaderServiceImpl.class);
    private BufferedReader bufferedReader;

    public ReaderServiceImpl(Socket socket) {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    @Override
    public String read() {
        String msg = null;
        try {
            msg = bufferedReader.readLine();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
        }
        return msg;
    }
}
