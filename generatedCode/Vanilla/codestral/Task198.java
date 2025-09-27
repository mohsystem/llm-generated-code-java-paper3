package Vanilla.codestral;
import java.util.Random;

class Solution {
    private int rand7() {
        Random rand = new Random();
        return rand.nextInt(7) + 1;
    }

    public int rand10() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 40) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 40;
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            a = idx - 60;
            b = rand7();
            idx = b + (a - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }
}

public class Task198 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rand10()); // Test case 1
        System.out.println(sol.rand10()); // Test case 2
        System.out.println(sol.rand10()); // Test case 3
        System.out.println(sol.rand10()); // Test case 4
        System.out.println(sol.rand10()); // Test case 5
    }
}