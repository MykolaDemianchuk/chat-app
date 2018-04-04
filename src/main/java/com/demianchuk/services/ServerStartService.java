package com.demianchuk.services;

import java.net.ServerSocket;

public interface ServerStartService {
    ServerSocket startServer(int port);
}
