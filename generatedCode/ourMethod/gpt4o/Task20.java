package ourMethod.openai;
public class Task20 {
    public static int findFunnyNumber(int n, int p) {
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
        System.out.println(findFunnyNumber(89, 1));    // 1
        System.out.println(findFunnyNumber(92, 1));    // -1
        System.out.println(findFunnyNumber(695, 2));   // 2
        System.out.println(findFunnyNumber(46288, 3)); // 51
        System.out.println(findFunnyNumber(123, 2));   // -1
    }
}