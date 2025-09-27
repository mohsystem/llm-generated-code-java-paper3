package Vanilla.gpt4o;
public class Task20 {
    public static int findK(int n, int p) {
        String numStr = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            sum += Math.pow(Character.getNumericValue(numStr.charAt(i)), p + i);
        }
        return sum % n == 0 ? sum / n : -1;
    }

    public static void main(String[] args) {
        System.out.println(findK(89, 1));   // 1
        System.out.println(findK(92, 1));   // -1
        System.out.println(findK(695, 2));  // 2
        System.out.println(findK(46288, 3)); // 51
        System.out.println(findK(123, 1));  // -1
    }
}