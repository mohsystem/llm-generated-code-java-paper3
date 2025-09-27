package ZeroShot.claude;

public class Task2 {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers == null || numbers.length != 10) {
            return "";
        }
        
        for (int n : numbers) {
            if (n < 0 || n > 9) {
                return "";
            }
        }
        
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
            numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
            numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);
    }
    
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
            {9, 9, 9, 8, 8, 8, 7, 7, 7, 6},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        
        for (int[] test : testCases) {
            System.out.println(createPhoneNumber(test));
        }
    }
}
