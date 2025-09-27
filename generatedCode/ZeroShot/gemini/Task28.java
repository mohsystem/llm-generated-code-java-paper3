package ZeroShot.gemini;
import java.util.Arrays;
import java.util.List;

class Task28 {
    public static String whoLikesIt(String... names) {
        int len = names.length;
        switch (len) {
            case 0:
                return "no one likes this";
            case 1:
                return names[0] + " likes this";
            case 2:
                return names[0] + " and " + names[1] + " like this";
            case 3:
                return names[0] + ", " + names[1] + " and " + names[2] + " like this";
            default:
                return names[0] + ", " + names[1] + " and " + (len - 2) + " others like this";
        }
    }

    public static void main(String[] args) {
        System.out.println(whoLikesIt());
        System.out.println(whoLikesIt("Peter"));
        System.out.println(whoLikesIt("Jacob", "Alex"));
        System.out.println(whoLikesIt("Max", "John", "Mark"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}