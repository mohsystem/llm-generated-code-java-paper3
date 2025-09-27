package CoT.gpt4o;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Task7 {

    public static void main(String[] args) {
        Task7 server = new Task7();
        server.runServer();

        Task7 client = new Task7();
        client.runClient("user1", "pass1");
        client.runClient("user2", "wrongpass");
        client.runClient("user1", "pass1");
        client.runClient("user3", "pass3");
        client.runClient("user4", "pass4");
    }

    private void runServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(12345)) {
                HashMap<String, String> users = new HashMap<>();
                users.put("user1", "pass1");
                users.put("user2", "pass2");
                users.put("user3", "pass3");

                while (true) {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> handleClient(socket, users)).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleClient(Socket socket, HashMap<String, String> users) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String username = in.readLine();
            String password = in.readLine();
            
            if (users.containsKey(username) && users.get(username).equals(password)) {
                out.println("Login successful");
            } else {
                out.println("Login failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runClient(String username, String password) {
        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 12345);
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                out.println(username);
                out.println(password);

                System.out.println("Client: " + in.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}