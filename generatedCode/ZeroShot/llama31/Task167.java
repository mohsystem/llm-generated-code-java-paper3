package ZeroShot.llama31;
public class Task167 {
    public static void main(String[] args) {
        System.out.printf("%.2f%n", cubeDiagonal(8));
        System.out.printf("%.2f%n", cubeDiagonal(343));
        System.out.printf("%.2f%n", cubeDiagonal(1157.625));
        System.out.printf("%.2f%n", cubeDiagonal(1000));
        System.out.printf("%.2f%n", cubeDiagonal(512));
    }

    public static double cubeDiagonal(double volume) {
        double sideLength = Math.pow(volume, 1.0 / 3.0);
        return Math.round(Math.sqrt(3) * sideLength * 100.0) / 100.0;
    }
}