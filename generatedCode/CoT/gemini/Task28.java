package CoT.gemini;
import java.util.Arrays;
import java.util.List;

class Task28 {
    public static String whoLikesIt(String... names) {
        List<String> nameList = Arrays.asList(names);
        int size = nameList.size();
        switch (size) {
            case 0:
                return "no one likes this";
            case 1:
                return nameList.get(0) + " likes this";
            case 2:
                return nameList.get(0) + " and " + nameList.get(1) + " like this";
            case 3:
                return nameList.get(0) + ", " + nameList.get(1) + " and " + nameList.get(2) + " like this";
            default:
                return nameList.get(0) + ", " + nameList.get(1) + " and " + (size - 2) + " others like this";
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