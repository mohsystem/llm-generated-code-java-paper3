package Vanilla.claude;

public class Task142 {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(findGCD(48, 36));  // 12
        System.out.println(findGCD(54, 24));  // 6 
        System.out.println(findGCD(7, 13));   // 1
        System.out.println(findGCD(45, 75));  // 15
        System.out.println(findGCD(100, 80)); // 20
    }
}
