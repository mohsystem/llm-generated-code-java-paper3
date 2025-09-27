package ourMethod.codestral;
public class Task58 {
    public static boolean XO(String str) {
        str = str.toLowerCase();
        int xCount = 0, oCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'x') {
                xCount++;
            } else if (c == 'o') {
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