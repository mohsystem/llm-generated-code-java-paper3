package ourMethod.llama31;
public class Task31 {
    public static void main(String[] args) {
        String[] testCases = {"ATTGC", "GTAT", "ATCG", "GCTA", "TCGA"};
        for (String testCase : testCases) {
            System.out.println("Input: " + testCase + " -> Output: " + getComplementaryDNA(testCase));
        }
    }

    public static String getComplementaryDNA(String dna) {
        if (dna == null || dna.isEmpty()) {
            throw new IllegalArgumentException("DNA strand cannot be empty or null");
        }
        StringBuilder complementary = new StringBuilder();
        for (char nucleotide : dna.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    complementary.append('T');
                    break;
                case 'T':
                    complementary.append('A');
                    break;
                case 'C':
                    complementary.append('G');
                    break;
                case 'G':
                    complementary.append('C');
                    break;
                default:
                    throw new IllegalArgumentException("Invalid DNA nucleotide: " + nucleotide);
            }
        }
        return complementary.toString();
    }
}