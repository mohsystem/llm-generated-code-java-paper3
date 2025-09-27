package ourMethod.claude;

public class Task11 {
    public static int nbYear(int p0, double percent, int aug, int p) {
        if (p0 <= 0 || percent < 0 || p <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        
        int years = 0;
        long currentPopulation = p0;
        double percentAsDecimal = percent / 100.0;
        
        while (currentPopulation < p) {
            currentPopulation = (long)(currentPopulation + (currentPopulation * percentAsDecimal) + aug);
            years++;
            
            // Check for potential overflow
            if (currentPopulation > Integer.MAX_VALUE) {
                throw new ArithmeticException("Population exceeded maximum value");
            }
        }
        return years;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(nbYear(1000, 2, 50, 1200));  // Expected: 3
        System.out.println(nbYear(1500, 5, 100, 5000)); // Expected: 15
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000)); // Expected: 10
        System.out.println(nbYear(1600, 2, 50, 2000));  // Expected: 13
        System.out.println(nbYear(1000, 2.0, 50, 1214)); // Expected: 4
    }
}
