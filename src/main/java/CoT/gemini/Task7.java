package CoT.gemini;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;

class Task7 {

    // Client-side code
    static class Client {
        public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 5000);
            Scanner scanner = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            out.println("LOGIN " + username + " " + password);

            String response = in.readLine();
            System.out.println(response);

            socket.close();
            scanner.close();

        }
    }


    // Server-side code
    static class Server {

        private static HashMap<String, String> users = new HashMap<>();

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started...");


            // Load users from file (replace with your actual file path)
            loadUsers("users.txt");


            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                new ClientHandler(clientSocket).start();
            }
        }

        // Load users from a file
        private static void loadUsers(String filePath) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        users.put(parts[0], parts[1]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Error loading users: " + e.getMessage());
            }
        }

        static class ClientHandler extends Thread {
            private final Socket clientSocket;

            public ClientHandler(Socket socket) {
                this.clientSocket = socket;
            }

            @Override
            public void run() {
                try {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    String request = in.readLine();
                    String[] parts = request.split(" ");

                    if (parts.length == 3 && parts[0].equals("LOGIN")) {
                        String username = parts[1];
                        String password = parts[2];

                        if (users.containsKey(username) && users.get(username).equals(password)) {
                            out.println("Login successful!");
                        } else {
                            out.println("Login failed!");
                        }
                    } else {
                        out.println("Invalid request!");
                    }


                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }

            }
        }

    }


    public static void main(String[] args) throws IOException, InterruptedException {

        // Test cases (run server in a separate thread)
        Thread serverThread = new Thread(() -> {
            try {
                Task7.Server.main(new String[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        Thread.sleep(1000); // Give the server time to start

        Task7.Client.main(new String[]{"user1", "pass1"}); // Correct credentials
        Task7.Client.main(new String[]{"user1", "wrong"}); // Incorrect password
        Task7.Client.main(new String[]{"invaliduser", "pass"}); // Invalid username
        Task7.Client.main(new String[]{"user2", "pass2"}); // Correct credentials (user2 should be in users.txt)
        Task7.Client.main(new String[]{"user2", ""});    // empty password

        serverThread.interrupt(); // Stop the server after tests
    }
}