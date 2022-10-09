package ru.client_server.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(8081)) {
                System.out.println("Starting the server!");
                try (Socket clientSocket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String fromClient = in.readLine();
                    System.out.println(fromClient);
                    out.write(String.format("Hi! Server response : Client send - \" %s \", your port is %d", fromClient, clientSocket.getPort()));
                    out.flush();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


}
