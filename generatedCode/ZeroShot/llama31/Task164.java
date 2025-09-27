package ZeroShot.llama31;
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
        // Using Java 8 streams and lambda expressions
        return java.util.Arrays.stream(names)
            .sorted((a, b) -> {
                String[] aParts = a.split(" ");
                String[] bParts = b.split(" ");
                int aLen = aParts[aParts.length - 1].length();
                int bLen = bParts[bParts.length - 1].length();
                if (aLen == bLen) {
                    return aParts[aParts.length - 1].compareTo(bParts[bParts.length - 1]);
                } else {
                    return Integer.compare(aLen, bLen);
                }
            })
            .toArray(String[]::new);
    }
}