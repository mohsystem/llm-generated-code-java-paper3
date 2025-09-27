package Vanilla.claude;

public class Task158 {
    public static String executeCommand(String input) {
        // Unsafe command execution with user input
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd.exe /c " + input); 
            return "Command executed: " + input;
        } catch(Exception e) {
            return "Error executing command";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(executeCommand("dir")); 
        System.out.println(executeCommand("echo hello"));
        System.out.println(executeCommand("type test.txt"));
        System.out.println(executeCommand("whoami"));
        System.out.println(executeCommand("hostname"));
    }
}
