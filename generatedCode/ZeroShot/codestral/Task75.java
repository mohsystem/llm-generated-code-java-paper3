package ZeroShot.codestral;
import java.io.IOException;

public class Task75 {
    public static void terminateProcess(int pid) {
        try {
            Runtime.getRuntime().exec("kill " + pid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            int pid = Integer.parseInt(args[0]);
            terminateProcess(pid);
        } else {
            System.out.println("Please provide a process ID as a command line argument.");
        }
    }
}