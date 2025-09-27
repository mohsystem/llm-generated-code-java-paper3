package CoT.codestral;
// Java
// This is a very simplified version and should be expanded for a production environment
// This is the server part
import java.io.*;
import java.net.*;
import java.util.*;

public class Task48 {
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        try (ServerSocket listener = new ServerSocket(59001)) {
            while (true) {
                new Handler(listener.accept()).start();
            }
        }
    }

    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (writers) {
                        if (!writers.contains(out)) {
                            writers.add(out);
                            break;
                        }
                    }
                }

                out.println("NAMEACCEPTED");
                for (PrintWriter writer : writers) {
                    writer.println("MESSAGE " + name + " has joined");
                }

                while (true) {
                    String input = in.readLine();
                    if (input.toLowerCase().equals("/quit")) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (name != null) {
                    writers.remove(out);
                }
                if (out != null) {
                    out.close();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}