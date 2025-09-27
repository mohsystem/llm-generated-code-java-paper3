package CoT.llama31;
public class Task142 {
    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {98, 56},
            {48, 18},
            {399, 437},
            {32, 20},
            {81, 153}
        };

        for (int[] testCase : testCases) {
            int a = testCase[0];
            int b = testCase[1];
            System.out.println("GCD of " + a + " and " + b + " is " + gcd(a, b));
        }
    }
}