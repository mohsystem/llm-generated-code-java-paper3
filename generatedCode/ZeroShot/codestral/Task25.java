package ZeroShot.codestral;
import java.util.ArrayList;
import java.util.List;

public class Task25 {
    public static List<String> number(List<String> lines) {
        List<String> numberedLines = new ArrayList<String>();
        for(int i = 0; i < lines.size(); i++) {
            numberedLines.add((i + 1) + ": " + lines.get(i));
        }
        return numberedLines;
    }

    public static void main(String[] args) {
        List<String> test = new ArrayList<String>();
        test.add("a");
        test.add("b");
        test.add("c");
        System.out.println(number(test));
    }
}