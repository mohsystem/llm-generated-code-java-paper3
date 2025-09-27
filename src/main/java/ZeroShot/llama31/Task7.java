package ZeroShot.llama31;
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
        loadUsers();
    }

    public void start() throws IOException {
        System.out.println("Server started. Waiting for clients...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            ClientHandler clientHandler = new ClientHandler(socket);
            new Thread(clientHandler).start();
        }
    }

    private void loadUsers() {
        // Simulate loading users from a file
        users.put("user1", "password1");
        users.put("user2", "password2");
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
                String request = in.readLine();
                String[] parts = request.split(" ");
                if (parts[0].equals("LOGIN")) {
                    String username = parts[1];
                    String password = parts[2];
                    if (users.containsKey(username) && users.get(username).equals(password)) {
                        out.println("LOGIN_SUCCESS");
                    } else {
                        out.println("LOGIN_FAILURE");
                    }
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

    public void login(String username, String password) throws IOException {
        out.println("LOGIN " + username + " " + password);
        String response = in.readLine();
        System.out.println(response);
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        ChatClient client = new ChatClient("localhost", 8000);
        client.login("user1", "password1");
        client.login("user2", "wrongpassword");
    }
}

public class Task7 {
    public static void main(String[] args) throws Exception {
        // Run server in a separate thread
        Thread serverThread = new Thread(() -> {
            try {
                ChatServer server = new ChatServer(8000);
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        // Run client
        ChatClient client = new ChatClient("localhost", 8000);
        client.login("user1", "password1");
        client.login("user2", "wrongpassword");
    }
}