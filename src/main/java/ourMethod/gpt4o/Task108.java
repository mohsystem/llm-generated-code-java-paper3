package ourMethod.gpt4o;
import java.io.*;
import java.net.*;
import java.util.concurrent.ConcurrentHashMap;

public class Task108 {

    private ConcurrentHashMap<String, String> dataStore;

    public Task108() {
        dataStore = new ConcurrentHashMap<>();
    }

    public synchronized String manipulateObject(String command, String key, String value) {
        switch (command.toLowerCase()) {
            case "put":
                return dataStore.put(key, value);
            case "get":
                return dataStore.get(key);
            case "remove":
                return dataStore.remove(key);
            default:
                return "Invalid command";
        }
    }

    public static void main(String[] args) {
        Task108 server = new Task108();
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    String commandLine = in.readLine();
                    String[] parts = commandLine.split(" ");
                    if (parts.length >= 2) {
                        String command = parts[0];
                        String key = parts[1];
                        String value = (parts.length == 3) ? parts[2] : null;
                        String result = server.manipulateObject(command, key, value);
                        out.println(result != null ? result : "No data");
                    } else {
                        out.println("Invalid input");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}