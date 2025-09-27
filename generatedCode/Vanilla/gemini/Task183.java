package Vanilla.gemini;
import java.util.ArrayList;
import java.util.List;

class Task183 {
    public static long largestProduct(String digits, int span) {
        if (span < 1 || span > digits.length()) {
            return 0; 
        }

        long maxProduct = 0;
        for (int i = 0; i <= digits.length() - span; i++) {
            long currentProduct = 1;
            for (int j = 0; j < span; j++) {
                currentProduct *= Character.getNumericValue(digits.charAt(i + j));
            }
            maxProduct = Math.max(maxProduct, currentProduct);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[]{"63915", "3", "162"});
        testCases.add(new String[]{"1027839564", "5", "7560"});
        testCases.add(new String[]{"73167176531330624919225119674426574742355349194934", "6", "23520"});
        testCases.add(new String[]{"99999", "3", "729"});
        testCases.add(new String[]{"123", "4", "0"});


        for (String[] testCase : testCases) {
            String input = testCase[0];
            int span = Integer.parseInt(testCase[1]);
            long expectedOutput = Long.parseLong(testCase[2]);
            long actualOutput = largestProduct(input, span);

            if (actualOutput == expectedOutput) {
                System.out.println("Test case passed: " + input + ", " + span + " -> " + actualOutput);
            } else {
                System.out.println("Test case failed: " + input + ", " + span + " -> " + actualOutput + " (expected " + expectedOutput + ")");
            }
        }
    }
}