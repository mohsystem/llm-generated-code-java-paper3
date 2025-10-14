package Vanilla.openai;
public class Task58 {
    public static boolean XO(String str) {
        int countX = 0;
        int countO = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'x') countX++;
            else if (c == 'o') countO++;
        }
        return countX == countO;
    }

    public static void main(String[] args) {
        System.out.println(XO("ooxx"));    // true
        System.out.println(XO("xooxx"));   // false
        System.out.println(XO("ooxXm"));   // true
        System.out.println(XO("zpzpzpp")); // true
        System.out.println(XO("zzoo"));    // false
    }
}