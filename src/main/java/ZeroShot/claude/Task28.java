package ZeroShot.claude;

public class Task28 {
    public static String whoLikesIt(String[] names) {
        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return names[0] + " likes this";
            case 2: return names[0] + " and " + names[1] + " like this";
            case 3: return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default: return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(whoLikesIt(new String[]{}));
        System.out.println(whoLikesIt(new String[]{"Peter"}));
        System.out.println(whoLikesIt(new String[]{"Jacob", "Alex"}));
        System.out.println(whoLikesIt(new String[]{"Max", "John", "Mark"}));
        System.out.println(whoLikesIt(new String[]{"Alex", "Jacob", "Mark", "Max"}));
    }
}
