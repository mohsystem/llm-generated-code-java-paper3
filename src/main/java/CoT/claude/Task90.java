package CoT.claude;

import java.io.*;
import java.net.*;
import java.util.*;

public class Task90 {
    private static final int PORT = 12345;
    private static HashSet<PrintWriter> writers = new HashSet<>();
    
    public static void main(String[] args) throws Exception {
        System.out.println("Chat server is running...");
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
        private String name;
        
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null || name.isEmpty()) {
                        return;
                    }
                    synchronized (writers) {
                        if (!writers.contains(out)) {
                            break;
                        }
                    }
                }
                
                out.println("NAMEACCEPTED");
                writers.add(out);
                
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
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
                } catch (IOException e) {}
            }
        }
    }
}
