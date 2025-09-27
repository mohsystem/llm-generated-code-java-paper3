package CoT.llama31;
import java.io.*;
import java.net.*;

public class Task90 {
    private ServerSocket serverSocket;

    public Task90(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client Connected");

                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Task90 server = new Task90(serverSocket);
        server.startServer();
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Client: " + message);
                writer.write("Server: " + message + "\n");
                writer.flush();
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}