package ZeroShot.gemini;
import java.io.*;
import java.net.*;

class Task96 {
    public static String echoServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        String message;
        while ((message = in.readLine()) != null) {
            out.println(message);
        }

        clientSocket.close();
        serverSocket.close();
        return "Server closed";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(echoServer(8080));
        System.out.println(echoServer(8081));
        System.out.println(echoServer(8082));
        System.out.println(echoServer(8083));
        System.out.println(echoServer(8084));

    }
}