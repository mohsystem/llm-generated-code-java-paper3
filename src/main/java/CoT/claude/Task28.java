package CoT.claude;

public class Task28 {
    public static String whoLikesIt(String... names) {
        switch (names.length) {
            case 0: return "no one likes this";
            case 1: return String.format("%s likes this", names[0]);
            case 2: return String.format("%s and %s like this", names[0], names[1]);
            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(whoLikesIt()); // "no one likes this"
        System.out.println(whoLikesIt("Peter")); // "Peter likes this"
        System.out.println(whoLikesIt("Jacob", "Alex")); // "Jacob and Alex like this"
        System.out.println(whoLikesIt("Max", "John", "Mark")); // "Max, John and Mark like this"
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max")); // "Alex, Jacob and 2 others like this"
    }
}
