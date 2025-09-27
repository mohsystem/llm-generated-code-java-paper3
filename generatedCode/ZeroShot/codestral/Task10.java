package ZeroShot.codestral;
public class Task10 {
    public static int getSum(int a, int b) {
        if (a == b)
            return a;

        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int sum = 0;

        for (int i = min; i <= max; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1, 0));  // 1
        System.out.println(getSum(1, 2));  // 3
        System.out.println(getSum(0, 1));  // 1
        System.out.println(getSum(1, 1));  // 1
        System.out.println(getSum(-1, 2));  // 2
    }
}