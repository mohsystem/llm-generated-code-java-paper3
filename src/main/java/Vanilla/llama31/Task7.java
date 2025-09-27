package Vanilla.llama31;
import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

// Server side
class ChatServer {
    private ServerSocket serverSocket;
    private Map<String, String> users = new HashMap<>();

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public void start() throws IOException {
        System.out.println("Server started. Waiting for clients...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            new Thread(new ClientHandler(socket)).start();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String[] credentials = in.readLine().split(",");
                String username = credentials[0];
                String password = credentials[1];
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    out.println("Login successful");
                    while (true) {
                        String message = in.readLine();
                        if (message.equals("exit")) {
                            break;
                        }
                        System.out.println("Client: " + message);
                        out.println("Server: Message received");
                    }
                } else {
                    out.println("Invalid credentials");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ChatServer server = new ChatServer(8000);
        server.start();
    }
}

// Client side
class ChatClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient(String serverName, int serverPort) throws UnknownHostException, IOException {
        socket = new Socket(serverName, serverPort);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() throws IOException {
        System.out.print("Enter username: ");
        String username = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.print("Enter password: ");
        String password = new BufferedReader(new InputStreamReader(System.in)).readLine();
        out.println(username + "," + password);
        String response = in.readLine();
        System.out.println(response);
        if (response.equals("Login successful")) {
            while (true) {
                System.out.print("Enter message (or 'exit' to quit): ");
                String message = new BufferedReader(new InputStreamReader(System.in)).readLine();
                if (message.equals("exit")) {
                    break;
                }
                out.println(message);
                response = in.readLine();
                System.out.println(response);
            }
        }
        socket.close();
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        ChatClient client = new ChatClient("localhost", 8000);
        client.start();
    }
}

public class Task7 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Test cases
        // Server
        Thread serverThread = new Thread(() -> {
            try {
                new ChatServer(8000).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Clients
        Thread clientThread1 = new Thread(() -> {
            try {
                new ChatClient("localhost", 8000).start();
//                todo Alternatives in a multi-catch statement cannot be related by subclassing
//Alternative UnknownHostException is a subclass of alternative IOException
//            } catch (UnknownHostException | IOException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        clientThread1.start();

        Thread clientThread2 = new Thread(() -> {
            try {
                new ChatClient("localhost", 8000).start();
            } catch ( IOException e) {
                e.printStackTrace();
            }
        });
        clientThread2.start();

        // More test cases can be added similarly
    }
}