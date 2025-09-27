package CoT.codestral;
public class Task6 {
    public static double findUniq(double arr[]) {
        if (arr[0] != arr[1]) {
            if (arr[0] == arr[2]) {
                return arr[1];
            } else {
                return arr[0];
            }
        } else {
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] != arr[0]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1})); // => 2.0
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0})); // => 0.55
    }
}