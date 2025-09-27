package Vanilla.gemini;
class Task139 {
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println(calculateArea(5));
        System.out.println(calculateArea(10));
        System.out.println(calculateArea(2.5));
        System.out.println(calculateArea(0));
        System.out.println(calculateArea(1));
    }
}