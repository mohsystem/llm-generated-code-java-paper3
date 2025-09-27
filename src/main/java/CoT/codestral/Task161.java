package CoT.codestral;
public class Task161 {
    static int knapSack(int capacity, int weights[], int values[], int n) {
        if (n == 0 || capacity == 0)
            return 0;
        if (weights[n - 1] > capacity)
            return knapSack(capacity, weights, values, n - 1);
        else
            return Math.max(values[n - 1] + knapSack(capacity - weights[n - 1], weights, values, n - 1), knapSack(capacity, weights, values, n - 1));
    }

    public static void main(String args[]) {
        int weights[] = {10, 20, 30};
        int values[] = {60, 100, 120};
        int capacity = 50;
        int n = values.length;
        System.out.println(knapSack(capacity, weights, values, n));
    }
}