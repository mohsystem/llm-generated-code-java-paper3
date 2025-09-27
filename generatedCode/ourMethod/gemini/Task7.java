package ourMethod.gemini;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class Task7 {

    static class Client {
        private String username;
        private String password;

        public void captureCredentials() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        public String constructLoginRequest() {
            return "LOGIN " + username + " " + password;
        }

        public void sendRequest(String request, String serverAddress, int serverPort) throws IOException {
            Socket socket = new Socket(serverAddress, serverPort);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(request);
            socket.close();
        }
    }


    static class Server {

        private HashMap<String, String> userCredentials;
        private int port;


        public Server(int port) {
            this.port = port;
            userCredentials = new HashMap<>();

        }
        public void loadCredentials(String filepath) throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 2) {
                        userCredentials.put(parts[0], parts[1]);
                    }
                }
            }
        }


        public void start() throws IOException {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String request = in.readLine();
                processRequest(request, clientSocket);
                clientSocket.close();
            }
        }

        private void processRequest(String request, Socket clientSocket) throws IOException {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String[] parts = request.split(" ");
            if (parts.length == 3 && parts[0].equals("LOGIN")) {
                String username = parts[1];
                String password = parts[2];
                if (authenticate(username, password)) {
                    out.println("LOGIN SUCCESS");
                } else {
                    out.println("LOGIN FAILED");
                }

            }
            else {
                out.println("INVALID REQUEST");
            }
        }

        private boolean authenticate(String username, String password) {
            return userCredentials.containsKey(username) && Objects.equals(userCredentials.get(username), password);
        }

    }



    public static void main(String[] args) throws IOException {
        // Test cases
        Server server = new Server(8080);
        server.loadCredentials("credentials.txt");
        server.start();


        Client client1 = new Client();
        client1.captureCredentials();
        String request1 = client1.constructLoginRequest();
        client1.sendRequest(request1, "localhost", 8080);


    }
}