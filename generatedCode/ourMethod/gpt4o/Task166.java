package ourMethod.gpt4o;
public class Task166 {
    public static int[] posNegSort(int[] arr) {
        int[] posArr = java.util.Arrays.stream(arr).filter(x -> x > 0).sorted().toArray();
        int posIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr[i] = posArr[posIndex++];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {6, 3, -2, 5, -8, 2, -2},
            {6, 5, 4, -1, 3, 2, -1, 1},
            {-5, -5, -5, -5, 7, -5},
            {},
            {3, -1, -2, 2, 1}
        };

        for (int[] testCase : testCases) {
            int[] result = posNegSort(testCase);
            System.out.println(java.util.Arrays.toString(result));
        }
    }
}