package ZeroShot.codestral;
public class Task58 {
    public static boolean XO(String str) {
        str = str.toLowerCase();
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'x') {
                countX++;
            } else if (str.charAt(i) == 'o') {
                countO++;
            }
        }
        return countX == countO;
    }

    public static void main(String[] args) {
        System.out.println(XO("ooxx")); // true
        System.out.println(XO("xooxx")); // false
        System.out.println(XO("ooxXm")); // true
        System.out.println(XO("zpzpzpp")); // true
        System.out.println(XO("zzoo")); // false
    }
}