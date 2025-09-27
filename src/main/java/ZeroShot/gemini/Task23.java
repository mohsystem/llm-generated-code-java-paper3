package ZeroShot.gemini;
public class Task23 {

    public static long findNb(long m) {
        long n = 0;
        long sum = 0;
        while (sum < m) {
            n++;
            sum += n * n * n;
        }
        return sum == m ? n : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(1071225)); // Expected: 45
        System.out.println(findNb(91716553919377L)); // Expected: -1
        System.out.println(findNb(4183059834009L)); // Expected: 2022
        System.out.println(findNb(247234522472345224L)); // Expected: -1
        System.out.println(findNb(1)); // Expected: 1

    }
}