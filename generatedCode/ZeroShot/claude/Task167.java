package ZeroShot.claude;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        double sideLength = Math.cbrt(volume);
        double diagonal = Math.sqrt(3) * sideLength;
        return Math.round(diagonal * 100.0) / 100.0;
    }
    
    public static void main(String[] args) {
        System.out.printf("%.2f\\n", cubeDiagonal(8));
        System.out.printf("%.2f\\n", cubeDiagonal(343));
        System.out.printf("%.2f\\n", cubeDiagonal(1157.625));
        System.out.printf("%.2f\\n", cubeDiagonal(27));
        System.out.printf("%.2f\\n", cubeDiagonal(125));
    }
}
