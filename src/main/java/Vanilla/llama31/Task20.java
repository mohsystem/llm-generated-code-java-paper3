package Vanilla.llama31;
public class Task20 {
    public static int findK(int n, int p) {
        String str = Integer.toString(n);
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += (long) Math.pow(Character.getNumericValue(str.charAt(i)), p + i);
        }
        if (sum % n == 0) {
            return (int) (sum / n);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findK(89, 1)); // 1
        System.out.println(findK(92, 1)); // -1
        System.out.println(findK(695, 2)); // 2
        System.out.println(findK(46288, 3)); // 51
        System.out.println(findK(100, 1)); // -1
    }
}