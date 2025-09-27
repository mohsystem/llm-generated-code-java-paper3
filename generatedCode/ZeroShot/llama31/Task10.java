package ZeroShot.llama31;
public class Task10 {
    public static void main(String[] args) {
        System.out.println(sumBetween(1, 0)); // 1
        System.out.println(sumBetween(1, 2)); // 3
        System.out.println(sumBetween(0, 1)); // 1
        System.out.println(sumBetween(1, 1)); // 1
        System.out.println(sumBetween(-1, 0)); // -1
        System.out.println(sumBetween(-1, 2)); // 2
    }

    public static int sumBetween(int a, int b) {
        if (a == b) return a;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return (max + min) * (max - min + 1) / 2;
    }
}