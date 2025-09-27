package ourMethod.gemini;
public class Task23 {

    public static long findNb(long m) {
        long n = 0;
        long totalVolume = 0;
        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
        }
        return totalVolume == m ? n : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(4183059834009L)); // Expected: 2022
        System.out.println(findNb(24723578342962L)); // Expected: -1
        System.out.println(findNb(135440716410000L));// Expected: 4824
        System.out.println(findNb(40539911473216L)); // Expected: 3568
        System.out.println(findNb(1071225)); // Expected: 45
        System.out.println(findNb(91716553919377L)); // Expected: -1


    }
}