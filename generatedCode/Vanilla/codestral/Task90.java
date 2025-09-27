package Vanilla.codestral;
import java.io.*;
import java.net.*;
import java.util.*;

public class Task90 {
    private static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            new Thread(clientHandler).start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());

                String received;
                while ((received = dis.readUTF()) != null) {
                    for (ClientHandler client : clients) {
                        client.dos.writeUTF(received);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}