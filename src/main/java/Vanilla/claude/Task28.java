package Vanilla.claude;

public class Task28 {
    public static String whoLikesIt(String[] names) {
        if (names == null || names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else if (names.length == 3) {
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        } else {
            int others = names.length - 2;
            return names[0] + ", " + names[1] + " and " + others + " others like this";
        }
    }
    
    public static void main(String[] args) {
        // Test case 1
        String[] test1 = {};
        System.out.println(whoLikesIt(test1));
        
        // Test case 2
        String[] test2 = {"Peter"};
        System.out.println(whoLikesIt(test2));
        
        // Test case 3
        String[] test3 = {"Jacob", "Alex"};
        System.out.println(whoLikesIt(test3));
        
        // Test case 4
        String[] test4 = {"Max", "John", "Mark"};
        System.out.println(whoLikesIt(test4));
        
        // Test case 5
        String[] test5 = {"Alex", "Jacob", "Mark", "Max"};
        System.out.println(whoLikesIt(test5));
    }
}
