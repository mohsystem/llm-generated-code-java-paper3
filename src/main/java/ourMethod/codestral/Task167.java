package ourMethod.codestral;
import java.lang.Math;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        double side = Math.cbrt(volume);
        return Math.round(side * Math.sqrt(3) * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8));         // Output: 3.46
        System.out.println(cubeDiagonal(343));        // Output: 12.12
        System.out.println(cubeDiagonal(1157.625));   // Output: 18.19
    }
}