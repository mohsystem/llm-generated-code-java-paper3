package ZeroShot.gpt4o;
import java.util.*;

public class Task164 {
    public static String[] lastNameLensort(String[] names) {
        Arrays.sort(names, (a, b) -> {
            String lastNameA = a.substring(a.lastIndexOf(' ') + 1);
            String lastNameB = b.substring(b.lastIndexOf(' ') + 1);
            if (lastNameA.length() != lastNameB.length()) {
                return Integer.compare(lastNameA.length(), lastNameB.length());
            } else {
                return lastNameA.compareTo(lastNameB);
            }
        });
        return names;
    }
    
    public static void main(String[] args) {
        String[] names1 = {"Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", "Nicole Yoder", "Melissa Hoffman"};
        String[] names2 = {"John Smith", "Alan Brown", "Robert Green", "Emily Stone", "Ava Carter"};
        String[] names3 = {"Sarah Connor", "James Cameron", "Tom Cruise", "Chris Pine", "Emma Watson"};
        String[] names4 = {"Morgan Freeman", "Matt Damon", "Jason Statham", "Brad Pitt", "Will Smith"};
        String[] names5 = {"Leonardo DiCaprio", "Kate Winslet", "Keanu Reeves", "Sandra Bullock", "Natalie Portman"};
        
        System.out.println(Arrays.toString(lastNameLensort(names1)));
        System.out.println(Arrays.toString(lastNameLensort(names2)));
        System.out.println(Arrays.toString(lastNameLensort(names3)));
        System.out.println(Arrays.toString(lastNameLensort(names4)));
        System.out.println(Arrays.toString(lastNameLensort(names5)));
    }
}