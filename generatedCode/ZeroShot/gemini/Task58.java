package ZeroShot.gemini;
public class Task58 {
    public static boolean XO(String str) {
        int xCount = 0;
        int oCount = 0;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                xCount++;
            } else if (str.charAt(i) == 'o') {
                oCount++;
            }
        }
        return xCount == oCount;
    }

    public static void main(String[] args) {
        System.out.println(XO("ooxx")); // true
        System.out.println(XO("xooxx")); // false
        System.out.println(XO("ooxXm")); // true
        System.out.println(XO("zpzpzpp")); // true
        System.out.println(XO("zzoo")); // false
    }
}