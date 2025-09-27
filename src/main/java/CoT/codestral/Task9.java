package CoT.codestral;
public class Task9 {
    public static String determineParity(int[] arr) {
        if (arr.length == 0) {
            return "even";
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(determineParity(new int[]{0})); // Output: "even"
        System.out.println(determineParity(new int[]{0, 1, 4})); // Output: "odd"
        System.out.println(determineParity(new int[]{0, -1, -5})); // Output: "even"
        System.out.println(determineParity(new int[]{})); // Output: "even"
        System.out.println(determineParity(new int[]{1, 2, 3, 4})); // Output: "even"
    }
}