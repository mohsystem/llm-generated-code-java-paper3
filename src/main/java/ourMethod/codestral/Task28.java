package ourMethod.codestral;
import java.util.List;

public class Task28 {
    public static String displayLikes(List<String> names) {
        int size = names.size();
        if (size == 0) {
            return "no one likes this";
        } else if (size == 1) {
            return names.get(0) + " likes this";
        } else if (size == 2) {
            return names.get(0) + " and " + names.get(1) + " like this";
        } else if (size == 3) {
            return names.get(0) + ", " + names.get(1) + " and " + names.get(2) + " like this";
        } else {
            return names.get(0) + ", " + names.get(1) + " and " + (size - 2) + " others like this";
        }
    }

    public static void main(String[] args) {
        System.out.println(displayLikes(List.of()));
        System.out.println(displayLikes(List.of("Peter")));
        System.out.println(displayLikes(List.of("Jacob", "Alex")));
        System.out.println(displayLikes(List.of("Max", "John", "Mark")));
        System.out.println(displayLikes(List.of("Alex", "Jacob", "Mark", "Max")));
    }
}