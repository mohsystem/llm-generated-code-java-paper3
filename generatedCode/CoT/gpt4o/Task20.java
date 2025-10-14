package CoT.openai;
public class Task20 {

    public static int findK(int n, int p) {
        String digits = Integer.toString(n);
        int sum = 0;
        
        for (int i = 0; i < digits.length(); i++) {
            sum += Math.pow(Character.getNumericValue(digits.charAt(i)), p + i);
        }
        
        if (sum % n == 0) {
            return sum / n;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findK(89, 1));    // Output: 1
        System.out.println(findK(92, 1));    // Output: -1
        System.out.println(findK(695, 2));   // Output: 2
        System.out.println(findK(46288, 3)); // Output: 51
        System.out.println(findK(10, 1));    // Output: -1
    }
}