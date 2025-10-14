package ourMethodv2.gpt4o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task164 {
    public static List<String> lastNameLensort(List<String> names) {
        names.sort(Comparator.comparingInt((String name) -> name.split(" ")[1].length())
                .thenComparing(name -> name.split(" ")[1]));
        return names;
    }

    public static void main(String[] args) {
        System.out.println(lastNameLensort(new ArrayList<>(Arrays.asList(
                "Jennifer Figueroa", "Heather Mcgee", "Amanda Schwartz", 
                "Nicole Yoder", "Melissa Hoffman"))));
        
        System.out.println(lastNameLensort(new ArrayList<>(Arrays.asList(
                "John Doe", "Jane Smith", "Alice Johnson", 
                "Emma Brown", "Will Evans"))));
        
        System.out.println(lastNameLensort(new ArrayList<>(Arrays.asList(
                "Chris Green", "Bob White", "Patricia Black", 
                "James Blue", "Mike Red"))));
        
        System.out.println(lastNameLensort(new ArrayList<>(Arrays.asList(
                "Anna Zed", "Zoe Yates", "Sam Xander", 
                "Luke Wills", "Leo Vance"))));
        
        System.out.println(lastNameLensort(new ArrayList<>(Arrays.asList(
                "Sara Cline", "Tommy Brock", "Paul Crow", 
                "Peter Dock", "Victor Tuck"))));
    }
}