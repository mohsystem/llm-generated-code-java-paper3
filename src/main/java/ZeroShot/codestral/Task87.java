package ZeroShot.codestral;
import java.io.FileWriter;
import java.io.IOException;

public class Task87 {
    static int binarySearch(int arr[], int x, long startTime) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x) {
                try {
                    FileWriter myWriter = new FileWriter("time.txt");
                    myWriter.write("Time taken: " + (System.nanoTime() - startTime) + "ns");
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                return m;
            }

            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};
        int x = 10;
        long startTime = System.nanoTime();
        int result = binarySearch(arr, x, startTime);
        if (result == -1)
            System.out.println("Element not present in array");
        else
            System.out.println("Element found at index " + result);
    }
}