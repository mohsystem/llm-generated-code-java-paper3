package ourMethod.llama31;
public class Task10 {
    public static void main(String[] args) {
        // Test cases
        System.out.println(sumBetween(1, 0));   // 1
        System.out.println(sumBetween(1, 2));   // 3
        System.out.println(sumBetween(0, 1));   // 1
        System.out.println(sumBetween(1, 1));   // 1
        System.out.println(sumBetween(-1, 0));  // -1
        System.out.println(sumBetween(-1, 2));  // 2
    }

    public static int sumBetween(int a, int b) {
        // Ensure a is the smaller number
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // Calculate the sum using the formula for the sum of an arithmetic series
        int sum = (b - a + 1) * (a + b) / 2;
        return sum;
    }
}