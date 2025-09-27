package Vanilla.gemini;
import java.io.*;
import java.net.*;

public class Task120 {

    public static String displayInputOnWebPage(String input) {
        String html = "<html><head><title>User Input</title></head><body><h1>User Input:</h1><p>" + input + "</p></body></html>";
        return html;
    }

    public static void main(String[] args) {
        String[] testCases = {"Hello, world!", "Test case 1", "Test case 2", "Test case 3", "Test case 4"};
        for (String testCase : testCases) {
            System.out.println(displayInputOnWebPage(testCase));
        }

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = reader.readLine();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String response = displayInputOnWebPage(input);
            writer.write("HTTP/1.1 200 OK\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + response.length() + "\r\n");
            writer.write("\r\n");
            writer.write(response);
            writer.flush();

            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}