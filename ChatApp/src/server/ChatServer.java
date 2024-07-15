package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 27710;
    private static Set<ClientHandler> clientHandlers = new HashSet<>();
    private static List<String> messageHistory = new ArrayList<>(); // To store message history

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Chat Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Create a new client handler
                ClientHandler handler = new ClientHandler(clientSocket);
                clientHandlers.add(handler);

                // Start a new thread for each client handler
                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void broadcastMessage(String message, ClientHandler sender) {
        synchronized (clientHandlers) {
            for (ClientHandler handler : clientHandlers) {
                handler.sendMessage(message);
            }
        }
    }

    public static void addToHistory(String message) {
        synchronized (messageHistory) {
            messageHistory.add(message);
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        synchronized (clientHandlers) {
            clientHandlers.remove(clientHandler);
            broadcastMessage(clientHandler.getUsername() + " has left the chat", null);
        }
    }

    // ClientHandler class manages individual clients
    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getUsername() {
            return username;
        }

        public void sendMessage(String message) {
            writer.println(message);
        }

        @Override
        public void run() {
            try {
                // Initial username prompt and handling
                writer.println("Enter your username:");
                username = reader.readLine();
                broadcastMessage(username + " has joined the chat room", null);

                // Handle client messages
                String message;
                while ((message = reader.readLine()) != null) {
                    addToHistory(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                    System.out.println(username + " disconnected.");
                    removeClient(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
