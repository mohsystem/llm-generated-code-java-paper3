package Vanilla.openai;
public class Task23 {
    public static int findNb(long m) {
        long sum = 0;
        int n = 0;
        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }
        return sum == m ? n : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(1071225)); // Output: 45
        System.out.println(findNb(91716553919377L)); // Output: -1
        System.out.println(findNb(4183059834009L)); // Output: 2022
        System.out.println(findNb(24723578342962L)); // Output: -1
        System.out.println(findNb(135440716410000L)); // Output: 4824
    }
}