package Vanilla.claude;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    private static final int PORT = 5000;
    private static HashSet<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

// Client code
class ChatClient {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public ChatClient() throws Exception {
        socket = new Socket("localhost", 5000);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Test cases
        String[] messages = {
            "Hello everyone!",
            "How are you doing?",
            "This is a test message",
            "Testing broadcast",
            "Goodbye!"
        };

        for(String msg : messages) {
            sendMessage(msg);
            Thread.sleep(1000);
        }
    }

    private void sendMessage(String message) {
        out.println(message);
    }

    public static void main(String[] args) throws Exception {
        new ChatClient();
    }
}
