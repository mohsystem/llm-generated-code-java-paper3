package ZeroShot.gpt4o;
import java.util.Scanner;

public class Task142 {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) {
        System.out.println(gcd(48, 18)); // 6
        System.out.println(gcd(56, 98)); // 14
        System.out.println(gcd(101, 103)); // 1
        System.out.println(gcd(20, 8)); // 4
        System.out.println(gcd(270, 192)); // 6
    }
}