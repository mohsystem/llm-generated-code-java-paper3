package CoT.claude;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        // Calculate side length from volume (cube root)
        double side = Math.cbrt(volume);
        
        // Calculate diagonal using formula: diagonal = side * sqrt(3)
        double diagonal = side * Math.sqrt(3);
        
        // Round to 2 decimal places
        return Math.round(diagonal * 100.0) / 100.0;
    }
    
    public static void main(String[] args) {
        // Test cases
        System.out.println(cubeDiagonal(8));       // Expected: 3.46
        System.out.println(cubeDiagonal(343));     // Expected: 12.12
        System.out.println(cubeDiagonal(1157.625)); // Expected: 18.19
        System.out.println(cubeDiagonal(27));      // Expected: 5.20
        System.out.println(cubeDiagonal(125));     // Expected: 8.66
    }
}
