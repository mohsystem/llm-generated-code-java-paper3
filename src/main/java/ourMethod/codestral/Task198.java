package ourMethod.codestral;
public class Task198 {
    public static int rand7() {
        return (int)(Math.random() * 7) + 1;
    }

    public static int rand10() {
        int num;
        do {
            num = (rand7() - 1) * 7 + rand7();
        } while (num > 40);
        return num % 10 + 1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rand10();
        }
        System.out.println(java.util.Arrays.toString(result));
    }
}