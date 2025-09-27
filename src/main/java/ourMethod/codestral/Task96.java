package ourMethod.codestral;
import java.io.*;
import java.net.*;

public class Task96 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Task96 <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    writer.println("Echo: " + inputLine);
                }

                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}