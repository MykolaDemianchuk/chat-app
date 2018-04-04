package com.demianchuk.services;

import java.net.ServerSocket;
import java.net.Socket;

public interface ClientAcceptService {
    Socket accept(ServerSocket serverSocket);
}
