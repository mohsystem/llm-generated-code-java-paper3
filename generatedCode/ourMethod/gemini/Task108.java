package ourMethod.gemini;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Task108 {

    private static final int PORT = 12345;
    private Map<String, Object> objects = new HashMap<>();

    public static void main(String[] args) {
        Task108 server = new Task108();
        server.start();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                    String command = (String) in.readObject();

                    switch (command) {
                        case "create":
                            String name = (String) in.readObject();
                            Object object = in.readObject();
                            objects.put(name, object);
                            out.writeObject("Object created");
                            break;
                        case "get":
                            name = (String) in.readObject();
                            object = objects.get(name);
                            out.writeObject(object);
                            break;
                        case "set":
                            name = (String) in.readObject();
                            object = in.readObject();
                            objects.put(name, object);
                            out.writeObject("Object updated");
                            break;
                        case "delete":
                            name = (String) in.readObject();
                            objects.remove(name);
                            out.writeObject("Object deleted");
                            break;
                        default:
                            out.writeObject("Invalid command");
                    }

                } catch (Exception e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}