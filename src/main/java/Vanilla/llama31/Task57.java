package Vanilla.llama31;
// Java program to find factorial of given number
class Task57 {
    // Method to find factorial of the given number
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    // Driver method
    public static void main(String[] args) {
        int[] testCases = {0, 1, 2, 5, 10};
        for (int num : testCases) {
            System.out.println("Factorial of " + num + " is " + factorial(num));
        }
    }
}