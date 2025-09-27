package ourMethod.llama31;
// Task108.java
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Task108 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8000)) {
            System.out.println("Server started. Waiting for client connections...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client request in a separate thread
                ClientHandler handler = new ClientHandler(socket);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

            // Receive object from client
            Serializable obj = (Serializable) in.readObject();
            System.out.println("Received object: " + obj);

            // Manipulate the object
            if (obj instanceof String) {
                String str = (String) obj;
                str = str.toUpperCase();
                out.writeObject(str);
            } else {
                out.writeObject("Unsupported object type");
            }
        } catch (Exception e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Error closing socket: " + e.getMessage());
            }
        }
    }
}