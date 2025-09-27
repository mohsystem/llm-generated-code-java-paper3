package ourMethod.codestral;
public class Task23 {
    public static int findNb(long m) {
        int n = 1;
        while (m > 0) {
            m -= (long) Math.pow(n, 3);
            if (m < 0) {
                return -1;
            }
            n++;
        }
        return m == 0 ? n - 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(1071225)); // 45
        System.out.println(findNb(91716553919377L)); // -1
    }
}