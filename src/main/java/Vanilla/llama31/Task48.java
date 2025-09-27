package Vanilla.llama31;
import java.io.*;
import java.net.*;
import java.util.*;

class Task48 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Task48 <server|client> <port>");
            return;
        }

        if (args[0].equals("server")) {
            Server server = new Server(Integer.parseInt(args[1]));
            server.start();
        } else if (args[0].equals("client")) {
            Client client = new Client(args[1], Integer.parseInt(args[2]));
            client.start();
        }
    }
}

class Server {
    private ServerSocket serverSocket;
    private List<Socket> clients = new ArrayList<>();
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                System.out.println("New client connected");

                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                while (true) {
                    String message = reader.readLine();
                    if (message == null) break;

                    System.out.println("Received from client: " + message);
                    broadcast(message, clientSocket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                clients.remove(clientSocket);
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(String message, Socket exclude) {
            for (Socket client : clients) {
                if (client != exclude) {
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

class Client {
    private Socket clientSocket;
    private String host;
    private int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try {
            clientSocket = new Socket(host, port);
            System.out.println("Connected to server");

            Thread receiverThread = new Thread(new MessageReceiver());
            receiverThread.start();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String message = scanner.nextLine();
                try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    writer.println(message);
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + host);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MessageReceiver implements Runnable {
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                while (true) {
                    String message = reader.readLine();
                    if (message == null) break;
                    System.out.println("Server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}