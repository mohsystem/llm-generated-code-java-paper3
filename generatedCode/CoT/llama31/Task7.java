package CoT.llama31;
// Task7.java (Server and Client in one file for simplicity)

import java.net.*;
import java.io.*;
import java.util.Scanner;

class Task7 {
    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("server")) {
            runServer();
        } else {
            runClient();
        }
    }

    public static void runServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(2000);
        System.out.println("Server started. Waiting for a client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client accepted.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Simple authentication
        String username = in.readLine();
        String password = in.readLine();

        if (authenticate(username, password)) {
            out.println("Login successful");
            chatServer(socket, in, out);
        } else {
            out.println("Login failed");
            socket.close();
        }

        serverSocket.close();
    }

    public static void runClient() throws Exception {
        Socket socket = new Socket("localhost", 2000);
        System.out.println("Connected to the server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        out.println(username);
        out.println(password);

        String response = in.readLine();
        if (response.equals("Login successful")) {
            chatClient(socket, in, out, scanner);
        } else {
            System.out.println("Login failed");
        }

        socket.close();
    }

    public static boolean authenticate(String username, String password) throws Exception {
        // Simulate reading from a file
        // In real scenarios, use secure methods to store and compare passwords
        return username.equals("user") && password.equals("pass");
    }

    public static void chatServer(Socket socket, BufferedReader in, PrintWriter out) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String message = in.readLine();
            if (message.equalsIgnoreCase("END")) {
                out.println("BYE");
                break;
            }
            System.out.println("Client: " + message);
            System.out.print("Server: ");
            message = stdin.readLine();
            out.println(message);
        }

        socket.close();
        in.close();
        out.close();
        stdin.close();
    }

    public static void chatClient(Socket socket, BufferedReader in, PrintWriter out, Scanner scanner) throws Exception {
        while (true) {
            System.out.print("Client: ");
            String message = scanner.nextLine();
            out.println(message);

            message = in.readLine();
            if (message.equalsIgnoreCase("BYE")) {
                break;
            }
            System.out.println("Server: " + message);
        }

        socket.close();
        in.close();
        out.close();
    }
}