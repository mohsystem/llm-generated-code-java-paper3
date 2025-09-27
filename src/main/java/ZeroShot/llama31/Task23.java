package ZeroShot.llama31;
public class Task23 {
    public static long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m) {
            sum += n * n * n;
            if (sum == m) {
                return n;
            }
            n++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(1071225)); // 45
        System.out.println(findNb(91716553919377L)); // -1
        System.out.println(findNb(4183059834009L)); // -1
        System.out.println(findNb(275815729916296L)); // -1
        System.out.println(findNb(0)); // -1
    }
}