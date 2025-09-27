package CoT.codestral;
import java.util.Scanner;

public class Task159 {
    public static void main(String[] args) {
        int size = 10;
        int[] buffer = new int[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = i;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an index to read from the buffer:");
        int index = scanner.nextInt();
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
        } else {
            System.out.println("Value at index " + index + ": " + buffer[index]);
        }
    }
}