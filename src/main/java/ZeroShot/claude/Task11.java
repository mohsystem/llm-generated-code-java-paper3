package ZeroShot.claude;

public class Task11 {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        int population = p0;
        
        while (population < p) {
            population += (int)(population * (percent/100)) + aug;
            years++;
        }
        
        return years;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(nbYear(1000, 2, 50, 1200));  // 3
        System.out.println(nbYear(1500, 5, 100, 5000)); // 15
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000)); // 10
        System.out.println(nbYear(1500, 0.25, 1000, 2000)); // 1
        System.out.println(nbYear(1000, 2.0, 50, 1214)); // 4
    }
}
