package Vanilla.llama31;
public class Task41 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();
            System.out.println("Processed string: " + input.trim());
        }
        scanner.close();
    }
}