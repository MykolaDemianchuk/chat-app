package com.demianchuk.services;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class WriterServiceImpl implements WriterService {
    private static final Logger LOGGER = Logger.getLogger(WriterServiceImpl.class);
    private BufferedWriter bufferedWriter;

    public WriterServiceImpl(OutputStream outputStream) {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    @Override
    public boolean write(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            LOGGER.warn(e.getMessage(), e);
            return false;
        }
        return true;
    }

}
