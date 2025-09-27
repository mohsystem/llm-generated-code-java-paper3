package Vanilla.llama31;
public class Task141 {
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String[] testCases = {"abdcfe", "Hello World", "Geeks for Geeks", "Python", "Reverse"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + ", Output: " + reverseString(testCase));
        }
    }
}