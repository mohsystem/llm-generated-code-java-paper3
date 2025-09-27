package CoT.llama31;
public class Task167 {
    public static void main(String[] args) {
        System.out.println(cubeDiagonal(8));    // ➞ 3.46
        System.out.println(cubeDiagonal(343));  // ➞ 12.12
        System.out.println(cubeDiagonal(1157.625)); // ➞ 18.19
        System.out.println(cubeDiagonal(1000));  // ➞ 17.32
        System.out.println(cubeDiagonal(125));   // ➞ 5.59
    }

    public static double cubeDiagonal(double volume) {
        double sideLength = Math.cbrt(volume);
        double diagonal = sideLength * Math.sqrt(3);
        return Math.round(diagonal * 100.0) / 100.0;
    }
}