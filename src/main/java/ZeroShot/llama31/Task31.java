package ZeroShot.llama31;
public class Task31 {
    public static void main(String[] args) {
        String[] testCases = {"ATTGC", "GTAT", "ATCG", "GCTA", "TCGA"};
        for (String testCase : testCases) {
            System.out.println(getComplementaryDNA(testCase));
        }
    }

    public static String getComplementaryDNA(String dna) {
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
            }
        }
        return complementary.toString();
    }
}