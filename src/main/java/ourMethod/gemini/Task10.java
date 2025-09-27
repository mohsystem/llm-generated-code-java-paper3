package ourMethod.gemini;
class Task10 {
    public int getSum(int a, int b) {
        if (a == b) {
            return a;
        }
        int sum = 0;
        int start = Math.min(a, b);
        int end = Math.max(a, b);
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Task10 task10 = new Task10();
        System.out.println(task10.getSum(1, 0));
        System.out.println(task10.getSum(1, 2));
        System.out.println(task10.getSum(0, 1));
        System.out.println(task10.getSum(1, 1));
        System.out.println(task10.getSum(-1, 0));
        System.out.println(task10.getSum(-1, 2));
    }
}