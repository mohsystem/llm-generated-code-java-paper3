package CoT.llama31;
import java.io.*;
import java.net.*;
import java.util.*;

class Task48 {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            // Start the server
            Server server = new Server(8000);
            server.start();
        } else if (args[0].equals("client")) {
            // Start a client
            Client client = new Client("localhost", 8000);
            client.start();
        }
    }
}

class Server extends Thread {
    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList<>();

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                ClientHandler handler = new ClientHandler(clientSocket);
                handler.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ClientHandler extends Thread {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;
                while ((message = reader.readLine()) != null) {
                    broadcast(message, clientSocket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void broadcast(String message, Socket sender) {
            for (Socket client : clients) {
                if (client != sender) {
                    try (PrintWriter writer = new PrintWriter(client.getOutputStream(), true)) {
                        writer.println(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Client extends Thread {
    private Socket clientSocket;
    private BufferedReader reader;
    private PrintWriter writer;

    public Client(String host, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(host, port);
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void run() {
        try (BufferedReader serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String message;
            while (true) {
                message = serverReader.readLine();
                if (message != null) {
                    System.out.println("Server: " + message);
                }
                message = reader.readLine();
                if (message != null) {
                    writer.println(message);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}