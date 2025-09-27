package CoT.gemini;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task113 {

    public static String concatenateStrings(List<String> strings) {
        StringBuilder concatenatedString = new StringBuilder();
        for (String str : strings) {
            concatenatedString.append(str);
        }
        return concatenatedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> strings1 = new ArrayList<>();
        strings1.add("Hello");
        strings1.add(" ");
        strings1.add("World");
        System.out.println(concatenateStrings(strings1));


        List<String> strings2 = new ArrayList<>();
        strings2.add("String");
        strings2.add("1");
        System.out.println(concatenateStrings(strings2));


        List<String> strings3 = new ArrayList<>();
        strings3.add("a");
        strings3.add("b");
        strings3.add("c");
        System.out.println(concatenateStrings(strings3));

        List<String> strings4 = new ArrayList<>();
        strings4.add("");
        System.out.println(concatenateStrings(strings4));


        List<String> strings5 = new ArrayList<>();
        strings5.add("Test");
        strings5.add(" ");
        strings5.add("case");
        strings5.add(" ");
        strings5.add("5");

        System.out.println(concatenateStrings(strings5));



    }
}