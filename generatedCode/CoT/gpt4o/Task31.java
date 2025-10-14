package CoT.openai;
public class Task31 {
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

    public static void main(String[] args) {
        System.out.println(getComplementaryDNA("ATTGC")); // Output: TAACG
        System.out.println(getComplementaryDNA("GTAT"));  // Output: CATA
        System.out.println(getComplementaryDNA("AAAA"));  // Output: TTTT
        System.out.println(getComplementaryDNA("CGCG"));  // Output: GCGC
        System.out.println(getComplementaryDNA("ATGC"));  // Output: TACG
    }
}