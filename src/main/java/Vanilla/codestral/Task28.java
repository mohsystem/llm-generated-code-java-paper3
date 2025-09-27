package Vanilla.codestral;
public class Task28 {
    public static String likes(String[] names) {
        int len = names.length;
        if (len == 0) {
            return "no one likes this";
        } else if (len == 1) {
            return names[0] + " likes this";
        } else if (len == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else if (len == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            return names[0] + ", " + names[1] + " and " + (len - 2) + " others like this";
        }
    }

    public static void main(String[] args) {
        System.out.println(likes(new String[]{}));
        System.out.println(likes(new String[]{"Peter"}));
        System.out.println(likes(new String[]{"Jacob", "Alex"}));
        System.out.println(likes(new String[]{"Max", "John", "Mark"}));
        System.out.println(likes(new String[]{"Alex", "Jacob", "Mark", "Max"}));
    }
}