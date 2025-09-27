package ZeroShot.llama31;
public class Task34 {
    public static boolean isNarcissistic(int number) {
        String str = String.valueOf(number);
        int n = str.length();
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += (int) Math.pow(Character.getNumericValue(c), n);
        }
        return sum == number;
    }

    public static void main(String[] args) {
        System.out.println(isNarcissistic(153)); // true
        System.out.println(isNarcissistic(1652)); // false
        System.out.println(isNarcissistic(407)); // true
        System.out.println(isNarcissistic(1634)); // true
        System.out.println(isNarcissistic(8208)); // true
    }
}