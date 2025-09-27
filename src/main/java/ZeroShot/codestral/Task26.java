package ZeroShot.codestral;
public class Task26 {
    public static int findIt(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findIt(new int[]{7}));
        System.out.println(findIt(new int[]{0}));
        System.out.println(findIt(new int[]{1,1,2}));
        System.out.println(findIt(new int[]{0,1,0,1,0}));
        System.out.println(findIt(new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1}));
    }
}