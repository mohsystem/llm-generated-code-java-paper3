package ourMethod.llama31;
public static int findMissingNumber(int[] arr) {
    if (arr == null || arr.length == 0) {
        throw new IllegalArgumentException("Array must not be null or empty");
    }
    int n = arr.length + 1;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) {
        if (num < 1 || num > n) {
            throw new IllegalArgumentException("Array must contain numbers from 1 to " + n);
        }
        actualSum += num;
    }
    return expectedSum - actualSum;
}