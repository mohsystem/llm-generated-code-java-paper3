package CoT.openai;
public class Task10 {
    public static int sumBetween(int a, int b) {
        int sum = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumBetween(1, 0));  // 1
        System.out.println(sumBetween(1, 2));  // 3
        System.out.println(sumBetween(0, 1));  // 1
        System.out.println(sumBetween(1, 1));  // 1
        System.out.println(sumBetween(-1, 2)); // 2
    }
}