package Vanilla.codestral;
import java.io.IOException;

public class Task158 {
    public static void executeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        executeCommand("ls");
        executeCommand("dir");
        executeCommand("pwd");
        executeCommand("echo 'Hello, World!'");
        executeCommand("cal");
    }
}