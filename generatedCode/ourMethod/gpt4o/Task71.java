package ourMethod.openai;
public class Task71 {
    public static Integer convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    public static void main(String[] args) {
        String[] testCases = {"123", "abc", "456", "78.9", "-10"};
        
        for (String testCase : testCases) {
            Integer result = convertStringToInt(testCase);
            System.out.println("Input: " + testCase + " | Output: " + result);
        }
    }
}