package ZeroShot.llama31;
import java.io.IOException;
import java.util.Scanner;

public class Task39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void displayFileContents(String filename) {
        try {
            Process process = Runtime.getRuntime().exec("cat " + filename);
            java.util.Scanner s = new java.util.Scanner(process.getInputStream());
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //todo method main(String[]) is already defined in class Task39
//    public static void main(String[] args) {
//        String[] testCases = {"test1.txt", "test2.txt", "test3.txt", "test4.txt", "test5.txt"};
//        for (String testCase : testCases) {
//            displayFileContents(testCase);
//        }
//    }
}