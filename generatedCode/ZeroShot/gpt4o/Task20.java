package ZeroShot.openai;
public class Task20 {
    public static int digPow(int n, int p) {
        String digits = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < digits.length(); i++) {
            sum += Math.pow(Character.getNumericValue(digits.charAt(i)), p + i);
        }
        if (sum % n == 0) {
            return sum / n;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(digPow(89, 1)); // 1
        System.out.println(digPow(92, 1)); // -1
        System.out.println(digPow(695, 2)); // 2
        System.out.println(digPow(46288, 3)); // 51
        System.out.println(digPow(46288, 5)); // -1
    }
}