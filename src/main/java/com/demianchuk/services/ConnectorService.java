package com.demianchuk.services;

import java.net.Socket;

public interface ConnectorService {
    Socket connect(String host, int port);
}



