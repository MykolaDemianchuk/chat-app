package com.demianchuk.services;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReaderServiceImpl implements ReaderService {
    private static final Logger LOGGER = Logger.getLogger(ReaderServiceImpl.class);
    private BufferedReader bufferedReader;

    public ReaderServiceImpl(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
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
