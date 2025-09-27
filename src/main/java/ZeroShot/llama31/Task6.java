package ZeroShot.llama31;
public class Task6 {
    public static double findUniq(double[] arr) {
        double first = arr[0];
        double second = arr[1];
        if (first != second) {
            if (first == arr[2]) {
                return second;
            } else {
                return first;
            }
        }
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != first) {
                return arr[i];
            }
        }
        return first; // This line should never be reached
    }
//todo D:\sourceCode\PhD\llm-generated-code-java-paper2\src\main\java\ZeroShot\llama31\Task25.java:11: error: incompatible types: String[][] cannot be converted to String[]
//        String[] testCases = new String[][]{
//                             ^


//    public static void main(String[] args) {
//        double[] testCases = {
//            {1, 1, 1, 2, 1, 1},
//            {0, 0, 0.55, 0, 0},
//            {3, 3, 3, 4, 3, 3},
//            {5, 5, 5, 5, 6},
//            {7, 7, 7, 8, 7}
//        };
//        for (double[] testCase : testCases) {
//            System.out.println("Unique element: " + findUniq(testCase));
//        }
//    }
}