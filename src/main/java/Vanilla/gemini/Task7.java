package Vanilla.gemini;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

class Task7 {

    static class Client {
        public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 5000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Username: ");
            String username = reader.readLine();
            System.out.print("Password: ");
            String password = reader.readLine();

            writer.println("LOGIN " + username + " " + password);

            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = serverReader.readLine();
            System.out.println(response);

            socket.close();
        }

    }
    static class Server {

        private static final Map<String, String> users = new HashMap<>();

        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(5000);
            users.put("user1", "pass1");
            users.put("user2", "pass2");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }
        }

        private static void handleClient(Socket clientSocket) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String request = reader.readLine();
            String[] parts = request.split(" ");

            if (parts.length == 3 && parts[0].equals("LOGIN")) {
                String username = parts[1];
                String password = parts[2];

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    writer.println("Login successful.");
                } else {
                    writer.println("Login failed.");
                }
            }

            clientSocket.close();
        }
    }



    public static void main(String[] args) throws IOException {
        // Test Cases (Run Server in a separate thread)
        Thread serverThread = new Thread(() -> {
            try {
                Server.main(new String[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        serverThread.start();

        Client.main(new String[]{"user1", "pass1"}); // Successful login
        Client.main(new String[]{"user2", "wrongpass"}); // Failed login
        Client.main(new String[]{"invaliduser", "pass"}); // Failed login
        Client.main(new String[]{"user2", "pass2"}); // Successful login
        Client.main(new String[]{"user1", "wrongpass"}); // Failed login


    }
}