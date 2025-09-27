package CoT.llama31;
import java.io.IOException;
import java.util.Scanner;

public class Task39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        scanner.close();

        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
            System.out.println(s.hasNext() ? s.next() : "File not found or no content");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}