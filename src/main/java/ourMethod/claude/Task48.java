package ourMethod.claude;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Pattern;

public class Task48 {
    private static final int MAX_MESSAGE_LENGTH = 1024;
    private static final int MAX_USERNAME_LENGTH = 50;
    private static final Pattern VALID_USERNAME = Pattern.compile("^[a-zA-Z0-9_-]+$");
    private static final int SERVER_PORT = 12345;
    
    static class ChatServer {
        private final Set<ClientHandler> clients = ConcurrentHashMap.newKeySet();
        private final ExecutorService executor = Executors.newCachedThreadPool();
        private ServerSocket serverSocket;
        
        public void start(int port) {
            try {
                serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(1000);
                System.out.println("Server started on port " + port);
            } catch (IOException e) {
                System.err.println("Failed to start server: " + e.getMessage());
            }
        }
        
        public void acceptClients(int maxClients) {
            int count = 0;
            while (count < maxClients && serverSocket != null) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    ClientHandler handler = new ClientHandler(clientSocket, this);
                    clients.add(handler);
                    executor.submit(handler);
                    count++;
                } catch (SocketTimeoutException e) {
                    break;
                } catch (IOException e) {
                    break;
                }
            }
        }
        
        public void broadcast(String message, ClientHandler sender) {
            if (message == null || message.length() > MAX_MESSAGE_LENGTH) {
                return;
            }
            String sanitized = sanitizeMessage(message);
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(sanitized);
                }
            }
        }
        
        public void removeClient(ClientHandler client) {
            clients.remove(client);
        }
        
        public void shutdown() {
            try {
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close();
                }
                executor.shutdownNow();
                for (ClientHandler client : clients) {
                    client.close();
                }
            } catch (IOException e) {
                System.err.println("Error during shutdown: " + e.getMessage());
            }
        }
        
        private String sanitizeMessage(String message) {
            if (message == null) return "";
            return message.replaceAll("[\\\\x00-\\\\x1F\\\\x7F]", "");
        }
    }
    
    static class ClientHandler implements Runnable {
        private final Socket socket;
        private final ChatServer server;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;
        
        public ClientHandler(Socket socket, ChatServer server) {
            this.socket = socket;
            this.server = server;
        }
        
        @Override
        public void run() {
            try {
                reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8));
                writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(), StandardCharsets.UTF_8), true);
                
                username = readUsername();
                if (username == null) {
                    close();
                    return;
                }
                
                server.broadcast(username + " joined the chat", this);
                
                String message;
                while ((message = reader.readLine()) != null) {
                    if (message.length() > MAX_MESSAGE_LENGTH) {
                        message = message.substring(0, MAX_MESSAGE_LENGTH);
                    }
                    server.broadcast(username + ": " + message, this);
                }
            } catch (IOException e) {
                // Client disconnected
            } finally {
                server.removeClient(this);
                if (username != null) {
                    server.broadcast(username + " left the chat", this);
                }
                close();
            }
        }
        
        private String readUsername() throws IOException {
            String name = reader.readLine();
            if (name == null || name.isEmpty() || name.length() > MAX_USERNAME_LENGTH) {
                return null;
            }
            if (!VALID_USERNAME.matcher(name).matches()) {
                return null;
            }
            return name;
        }
        
        public void sendMessage(String message) {
            if (writer != null) {
                writer.println(message);
            }
        }
        
        public void close() {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
    
    static class ChatClient {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        
        public boolean connect(String host, int port, String username) {
            if (username == null || username.isEmpty() || username.length() > MAX_USERNAME_LENGTH) {
                return false;
            }
            if (!VALID_USERNAME.matcher(username).matches()) {
                return false;
            }
            
            try {
                socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), 2000);
                reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream(), StandardCharsets.UTF_8));
                writer = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream(), StandardCharsets.UTF_8), true);
                writer.println(username);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        
        public void sendMessage(String message) {
            if (writer != null && message != null && message.length() <= MAX_MESSAGE_LENGTH) {
                writer.println(message);
            }
        }
        
        public String receiveMessage(int timeoutMs) {
            try {
                socket.setSoTimeout(timeoutMs);
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }
        
        public void disconnect() {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (socket != null && !socket.isClosed()) socket.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
    
    public static void main(String[] args) {
        // Test case 1: Server starts and accepts connections
        System.out.println("Test 1: Server startup");
        ChatServer server = new ChatServer();
        server.start(SERVER_PORT);
        
        // Test case 2: Multiple clients connect
        System.out.println("\\nTest 2: Multiple clients connect");
        ChatClient client1 = new ChatClient();
        ChatClient client2 = new ChatClient();
        
        new Thread(() -> server.acceptClients(5)).start();
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        boolean connected1 = client1.connect("localhost", SERVER_PORT, "Alice");
        boolean connected2 = client2.connect("localhost", SERVER_PORT, "Bob");
        
        System.out.println("Client1 connected: " + connected1);
        System.out.println("Client2 connected: " + connected2);
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        // Test case 3: Message broadcasting
        System.out.println("\\nTest 3: Message broadcasting");
        client1.sendMessage("Hello from Alice");
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        String msg = client2.receiveMessage(500);
        System.out.println("Client2 received: " + msg);
        
        // Test case 4: Invalid username rejection
        System.out.println("\\nTest 4: Invalid username rejection");
        ChatClient client3 = new ChatClient();
        boolean connected3 = client3.connect("localhost", SERVER_PORT, "Invalid@User!");
        System.out.println("Client3 with invalid username connected: " + connected3);
        
        // Test case 5: Message length validation
        System.out.println("\\nTest 5: Message length validation");
        StringBuilder longMsg = new StringBuilder();
        for (int i = 0; i < 2000; i++) {
            longMsg.append("x");
        }
        client1.sendMessage(longMsg.toString());
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        
        String truncated = client2.receiveMessage(500);
        System.out.println("Long message handled: " + (truncated != null));
        
        // Cleanup
        client1.disconnect();
        client2.disconnect();
        client3.disconnect();
        server.shutdown();
        
        System.out.println("\\nAll tests completed");
    }
}
