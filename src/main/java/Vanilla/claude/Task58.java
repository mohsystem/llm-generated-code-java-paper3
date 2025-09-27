package Vanilla.claude;

public class Task58 {
    public static boolean XO(String str) {
        str = str.toLowerCase();
        int x = 0, o = 0;
        
        for(char c : str.toCharArray()) {
            if(c == 'x') x++;
            if(c == 'o') o++;
        }
        
        return x == o;
    }
    
    public static void main(String[] args) {
        System.out.println(XO("ooxx"));     // true
        System.out.println(XO("xooxx"));    // false
        System.out.println(XO("ooxXm"));    // true
        System.out.println(XO("zpzpzpp"));  // true
        System.out.println(XO("zzoo"));     // false
    }
}
