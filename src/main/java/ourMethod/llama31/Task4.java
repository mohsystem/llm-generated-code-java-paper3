package ourMethod.llama31;
public class Task4 {
    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        int[] mapHash = new int[26];
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                mapHash[c - 'a']++;
                if (mapHash[c - 'a'] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] testCases = {"Dermatoglyphics", "aba", "moOse", ""};
        for (String testCase : testCases) {
            System.out.println(testCase + " --> " + isIsogram(testCase));
        }
    }
}