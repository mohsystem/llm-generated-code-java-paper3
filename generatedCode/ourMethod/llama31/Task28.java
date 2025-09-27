package ourMethod.llama31;
public class Task28 {
    public static void main(String[] args) {
        String[] testCases = new String[] {
            "",
            "Peter",
            "Jacob,Alex",
            "Max,John,Mark",
            "Alex,Jacob,Mark,Max"
        };

        for (String testCase : testCases) {
            String[] names = testCase.split(",");
            System.out.println(getLikesText(names));
        }
    }

    public static String getLikesText(String[] names) {
        if (names.length == 0) {
            return "no one likes this";
        } else if (names.length == 1) {
            return names[0] + " likes this";
        } else if (names.length == 2) {
            return names[0] + " and " + names[1] + " like this";
        } else {
            return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        }
    }
}