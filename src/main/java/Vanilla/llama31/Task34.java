package Vanilla.llama31;
public class Task34 {
    public static boolean isNarcissistic(int n) {
        String str = String.valueOf(n);
        int digits = str.length();
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += (int) Math.pow(c - '0', digits);
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153));  // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(407));  // true
        System.out.println(isNarcissistic(1634)); // true
        System.out.println(isNarcissistic(8208)); // true
    }
}