package Vanilla.codestral;
public class Task27 {
    public static int find(int[] integers) {
        int odd = 0, even = 0, oddCount = 0, evenCount = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                even += integers[i];
                evenCount++;
            } else {
                odd += integers[i];
                oddCount++;
            }
        }
        return oddCount > evenCount ? even : odd;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{2, 4, 0, 100, 4, 11, 2602, 36})); // 11
        System.out.println(find(new int[]{160, 3, 1719, 19, 11, 13, -21})); // 160
    }
}