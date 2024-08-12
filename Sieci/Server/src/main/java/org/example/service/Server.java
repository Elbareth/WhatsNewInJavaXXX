package org.example.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void startAndRun()
    {
        try (ServerSocket  serverSocket = new ServerSocket(8189))
        {
            while (true)
            {
                Socket socket = serverSocket.accept();
                ServerHandler serverHandler = new ServerHandler(socket);
                Thread newThread = new Thread(serverHandler);
                newThread.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
