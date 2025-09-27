package ZeroShot.claude;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    private static final int PORT = 12345;
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Chat Server is running...");
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (writers) {
                    writers.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    synchronized (writers) {
                        for (PrintWriter writer : writers) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    synchronized (writers) {
                        writers.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}

// Client code
class ChatClient {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        Thread receiver = new Thread(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        });
        receiver.start();

        String userInput;
        while ((userInput = consoleInput.readLine()) != null) {
            out.println(userInput);
        }
    }
}
