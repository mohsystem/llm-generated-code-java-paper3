package ourMethod.gemini;
import java.util.ArrayList;
import java.util.List;

class Task198 {
    private int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public int rand10() {
        int num = (rand7() - 1) * 7 + rand7();
        while (num > 40) {
            num = (rand7() - 1) * 7 + rand7();
        }
        return (num - 1) % 10 + 1;
    }

    public static void main(String[] args) {
        Task198 task = new Task198();
        System.out.println(task.test(1));
        System.out.println(task.test(2));
        System.out.println(task.test(3));
        System.out.println(task.test(4));
        System.out.println(task.test(5));
    }


    public List<Integer> test(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(rand10());
        }
        return res;
    }
}