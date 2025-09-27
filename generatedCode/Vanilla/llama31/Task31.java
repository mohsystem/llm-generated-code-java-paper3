package Vanilla.llama31;
public class Task31 {
    public static String dnaComplement(String dna) {
        StringBuilder complement = new StringBuilder();
        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A':
                    complement.append('T');
                    break;
                case 'T':
                    complement.append('A');
                    break;
                case 'G':
                    complement.append('C');
                    break;
                case 'C':
                    complement.append('G');
                    break;
            }
        }
        return complement.toString();
    }

    public static void main(String[] args) {
        String[] testCases = {"ATTGC", "GTAT", "ATCG", "TGCA", "GATTACA"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " Output: " + dnaComplement(testCase));
        }
    }
}