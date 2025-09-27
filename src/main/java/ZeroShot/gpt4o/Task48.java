package ZeroShot.gpt4o;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private static List<ClientHandler> clientHandlers = Collections.synchronizedList(new ArrayList<>());

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, in, out);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = in.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, in, out);
                break;
            }
        }
    }

    public void broadcastMessage(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                if (!clientHandler.socket.equals(socket)) {
                    clientHandler.out.write(message);
                    clientHandler.out.newLine();
                    clientHandler.out.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, in, out);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("Server: " + socket + " has left the chat.");
    }

    public void closeEverything(Socket socket, BufferedReader in, BufferedWriter out) {
        removeClientHandler();
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Task48 {
    private ServerSocket serverSocket;

    public Task48(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected.");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Task48 server = new Task48(serverSocket);
        server.startServer();
    }
}