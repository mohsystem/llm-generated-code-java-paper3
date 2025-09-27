package ourMethod.llama31;
public class Task113 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter the number of strings to concatenate:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter string " + (i + 1) + ":");
            result.append(scanner.nextLine());
        }

        System.out.println("Concatenated String: " + result.toString());
    }
}