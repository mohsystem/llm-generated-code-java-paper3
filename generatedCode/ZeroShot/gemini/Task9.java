package ZeroShot.gemini;
import java.util.List;

class Task9 {
    public String oddOrEven(List<Integer> array) {
        int sum = 0;
        if (array == null || array.isEmpty()) {
            return "even";
        }
        for (int num : array) {
            sum += num;
        }
        return (sum % 2 == 0) ? "even" : "odd";
    }

    public static void main(String[] args) {
        Task9 task9 = new Task9();
        System.out.println(task9.oddOrEven(List.of(0)));
        System.out.println(task9.oddOrEven(List.of(0, 1, 4)));
        System.out.println(task9.oddOrEven(List.of(0, -1, -5)));
        System.out.println(task9.oddOrEven(List.of(1, 2, 3, 4, 5)));
        System.out.println(task9.oddOrEven(List.of()));


    }
}