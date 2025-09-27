package ourMethod.claude;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be positive");
        }
        
        // Calculate side length from volume (volume = side^3)
        double side = Math.cbrt(volume);
        
        // Main diagonal = side * sqrt(3)  
        double diagonal = side * Math.sqrt(3);
        
        // Round to 2 decimal places
        return Math.round(diagonal * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.printf("%.2f%n", cubeDiagonal(8));         // Should print 3.46
        System.out.printf("%.2f%n", cubeDiagonal(343));       // Should print 12.12
        System.out.printf("%.2f%n", cubeDiagonal(1157.625));  // Should print 18.19
        System.out.printf("%.2f%n", cubeDiagonal(1));         // Should print 1.73
        System.out.printf("%.2f%n", cubeDiagonal(27));        // Should print 5.20
    }
}
