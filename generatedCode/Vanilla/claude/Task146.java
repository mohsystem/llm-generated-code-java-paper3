package Vanilla.claude;

class Task146 {
    static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;
        for(int num : arr) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }
    
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 4, 5}, // missing 3
            {1, 3, 4, 5}, // missing 2
            {2, 3, 4, 5}, // missing 1
            {1, 2, 3, 5}, // missing 4
            {1, 2, 3, 4}  // missing 5
        };
        
        for(int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i+1) + ": Missing number is " + 
                             findMissingNumber(testCases[i]));
        }
    }
}
