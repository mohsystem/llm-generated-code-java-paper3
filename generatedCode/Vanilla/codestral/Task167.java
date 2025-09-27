package Vanilla.codestral;
import java.lang.Math;

public class Task167 {
    public static double cubeDiagonal(double volume) {
        double length = Math.cubeRoot(volume);
        return Math.round(Math.sqrt(3) * length * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8)); // 3.46
        System.out.println(cubeDiagonal(343)); // 12.12
        System.out.println(cubeDiagonal(1157.625)); // 18.19
    }
}