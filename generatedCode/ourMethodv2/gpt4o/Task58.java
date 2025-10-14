package ourMethodv2.gpt4o;
public class Task58 {
    public static boolean XO(String input) {
        int xCount = 0;
        int oCount = 0;
        
        for (char c : input.toLowerCase().toCharArray()) {
            if (c == 'x') {
                xCount++;
            } else if (c == 'o') {
                oCount++;
            }
        }
        
        return xCount == oCount;
    }

    public static void main(String[] args) {
        System.out.println(XO("ooxx"));   // true
        System.out.println(XO("xooxx"));  // false
        System.out.println(XO("ooxXm"));  // true
        System.out.println(XO("zpzpzpp"));// true
        System.out.println(XO("zzoo"));   // false
    }
}