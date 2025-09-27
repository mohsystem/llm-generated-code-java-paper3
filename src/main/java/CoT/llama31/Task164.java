package CoT.llama31;
public class Task164 {
    public static void main(String[] args) {
        String[] names = {
            "Jennifer Figueroa",
            "Heather Mcgee",
            "Amanda Schwartz",
            "Nicole Yoder",
            "Melissa Hoffman"
        };

        String[] sortedNames = lastNameLenSort(names);
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }

    public static String[] lastNameLenSort(String[] names) {
        // Step-by-step reasoning process
        // 1. Split each name into first and last names
        // 2. Create a custom comparator to sort by last name length and then alphabetically
        // 3. Use Arrays.sort with the custom comparator

        java.util.Arrays.sort(names, (a, b) -> {
            String[] aParts = a.split(" ");
            String[] bParts = b.split(" ");
            int aLen = aParts[1].length();
            int bLen = bParts[1].length();

            if (aLen == bLen) {
                return aParts[1].compareTo(bParts[1]);
            } else {
                return Integer.compare(aLen, bLen);
            }
        });

        return names;
    }
}