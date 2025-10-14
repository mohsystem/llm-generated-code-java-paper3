package Vanilla.openai;
public class Task167 {
    public static double cubeDiagonal(double volume) {
        double side = Math.cbrt(volume);
        double diagonal = side * Math.sqrt(3);
        return Math.round(diagonal * 100.0) / 100.0;
    }
    
    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8));        // 3.46
        System.out.println(cubeDiagonal(343));      // 12.12
        System.out.println(cubeDiagonal(1157.625)); // 18.19
        System.out.println(cubeDiagonal(1));        // 1.73
        System.out.println(cubeDiagonal(27));       // 5.20
    }
}