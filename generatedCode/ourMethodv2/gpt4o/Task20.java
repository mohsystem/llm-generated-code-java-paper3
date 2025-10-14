package ourMethodv2.gpt4o;
public class Task20 {
    public static int findK(int n, int p) {
        String numStr = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, p + i);
        }
        if (sum % n == 0) {
            return sum / n;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findK(89, 1));    // 1
        System.out.println(findK(92, 1));    // -1
        System.out.println(findK(695, 2));   // 2
        System.out.println(findK(46288, 3)); // 51
        System.out.println(findK(123, 1));   // -1
    }
}