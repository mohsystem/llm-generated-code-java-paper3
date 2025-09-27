package ZeroShot.claude;

public class Task10 {
    public static int getSum(int a, int b) {
        if (a == b) return a;
        
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        
        return (end - start + 1) * (start + end) / 2;
    }
    
    public static void main(String[] args) {
        System.out.println(getSum(1, 0));  // 1
        System.out.println(getSum(1, 2));  // 3
        System.out.println(getSum(0, 1));  // 1
        System.out.println(getSum(1, 1));  // 1
        System.out.println(getSum(-1, 2)); // 2
    }
}
