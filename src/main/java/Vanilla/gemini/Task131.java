package Vanilla.gemini;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task131 {
    public static List<Integer> deserialize(String data) {
        if (data == null || data.isEmpty() || !data.startsWith("[") || !data.endsWith("]")) {
            return new ArrayList<>(); // Return empty list for invalid input
        }

        String[] elements = data.substring(1, data.length() - 1).split(",");
        List<Integer> result = new ArrayList<>();
        for (String element : elements) {
            try {
                result.add(Integer.parseInt(element.trim()));
            } catch (NumberFormatException e) {
                // Ignore invalid elements
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(deserialize("[1, 2, 3]")); // Output: [1, 2, 3]
        System.out.println(deserialize("[]")); // Output: []
        System.out.println(deserialize("[1,a,2,3]")); // Output: [1, 2, 3]
        System.out.println(deserialize(null)); // Output: []
        System.out.println(deserialize("1, 2, 3")); // Output: []
    }
}