package ZeroShot.claude;

public class Task20 {
    public static long digPow(long n, int p) {
        String numStr = String.valueOf(n);
        long sum = 0;
        
        for(int i = 0; i < numStr.length(); i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, p + i);
        }
        
        return sum % n == 0 ? sum / n : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(digPow(89, 1));     // 1
        System.out.println(digPow(92, 1));     // -1
        System.out.println(digPow(695, 2));    // 2
        System.out.println(digPow(46288, 3));  // 51
        System.out.println(digPow(123, 1));    // -1
    }
}
