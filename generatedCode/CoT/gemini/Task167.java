package CoT.gemini;
import java.lang.Math;

class Task167 {
    public static double cubeDiagonal(double volume) {
        double side = Math.cbrt(volume);
        double diagonal = side * Math.sqrt(3);
        return (double) Math.round(diagonal * 100) / 100;
    }

    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8));
        System.out.println(cubeDiagonal(343));
        System.out.println(cubeDiagonal(1157.625));
        System.out.println(cubeDiagonal(1));
        System.out.println(cubeDiagonal(0));


    }
}