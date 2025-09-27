package Vanilla.llama31;
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
        // Sort the array based on the length of last names and then alphabetically
        java.util.Arrays.sort(names, (a, b) -> {
            String lastNameA = a.substring(a.lastIndexOf(' ') + 1);
            String lastNameB = b.substring(b.lastIndexOf(' ') + 1);
            if (lastNameA.length() == lastNameB.length()) {
                return lastNameA.compareTo(lastNameB);
            } else {
                return Integer.compare(lastNameA.length(), lastNameB.length());
            }
        });
        return names;
    }
}