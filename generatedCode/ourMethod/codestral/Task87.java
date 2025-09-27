package ourMethod.codestral;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task87 {
    public static int binarySearch(int arr[], int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};
        int n = arr.length;
        int x = 10;
        long startTime = System.nanoTime();
        int result = binarySearch(arr, x);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        try {
            FileWriter myWriter = new FileWriter("execution_time.txt");
            myWriter.write("Execution time: " + duration + " nanoseconds");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}