package CoT.llama31;
public class Task10 {
    public static void main(String[] args) {
        System.out.println(sumBetween(1, 0)); // 1
        System.out.println(sumBetween(1, 2)); // 3
        System.out.println(sumBetween(0, 1)); // 1
        System.out.println(sumBetween(1, 1)); // 1
        System.out.println(sumBetween(-1, 0)); // -1
        System.out.println(sumBetween(-1, 2)); // 2
    }

    public static int sumBetween(int a, int b) {
        if (a == b) return a;
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}