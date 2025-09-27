package CoT.codestral;
public class Task27 {
    public static int findOutlier(int[] arr) {
        int countEven = 0, countOdd = 0, even = 0, odd = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
                even = arr[i];
            } else {
                countOdd++;
                odd = arr[i];
            }
        }

        for (int i = 3; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
                even = arr[i];
            } else {
                countOdd++;
                odd = arr[i];
            }

            if (countEven > 1 && countOdd == 1) {
                return odd;
            } else if (countOdd > 1 && countEven == 1) {
                return even;
            }
        }

        return countEven > countOdd ? odd : even;
    }

    public static void main(String[] args) {
        System.out.println(findOutlier(new int[]{2, 4, 0, 100, 4, 11, 2602, 36}));
        System.out.println(findOutlier(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }
}