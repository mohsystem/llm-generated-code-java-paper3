package ZeroShot.gpt4o;
import java.lang.Math;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        if (volume < 0) throw new IllegalArgumentException("Volume must be non-negative.");
        double side = Math.cbrt(volume);
        return Math.round(Math.sqrt(3) * side * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8)); // ➞ 3.46
        System.out.println(cubeDiagonal(343)); // ➞ 12.12
        System.out.println(cubeDiagonal(1157.625)); // ➞ 18.19
        System.out.println(cubeDiagonal(0)); // ➞ 0.0
        System.out.println(cubeDiagonal(1)); // ➞ 1.73
    }
}