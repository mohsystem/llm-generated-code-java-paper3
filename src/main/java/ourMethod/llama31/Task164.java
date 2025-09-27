package ourMethod.llama31;
public class Task164 {
    public static void main(String[] args) {
        String[] names = {
            "Jennifer Figueroa",
            "Heather Mcgee",
            "Amanda Schwartz",
            "Nicole Yoder",
            "Melissa Hoffman"
        };

        String[] sortedNames = lastNameLensort(names);
        for (String name : sortedNames) {
            System.out.println(name);
        }
    }

    public static String[] lastNameLensort(String[] names) {
        // Use Arrays.sort with a custom comparator
        java.util.Arrays.sort(names, (a, b) -> {
            String[] aParts = a.split(" ");
            String[] bParts = b.split(" ");
            int aLastNameLength = aParts[aParts.length - 1].length();
            int bLastNameLength = bParts[bParts.length - 1].length();

            if (aLastNameLength == bLastNameLength) {
                return aParts[aParts.length - 1].compareTo(bParts[bParts.length - 1]);
            } else {
                return Integer.compare(aLastNameLength, bLastNameLength);
            }
        });

        return names;
    }
}