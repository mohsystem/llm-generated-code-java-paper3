package CoT.llama31;
public class Task31 {
    public static void main(String[] args) {
        System.out.println(dnaComplement("ATTGC")); // TAACG
        System.out.println(dnaComplement("GTAT"));  // CATA
        System.out.println(dnaComplement("ATCG"));  // TAGC
        System.out.println(dnaComplement("GCTA"));  // CGAT
        System.out.println(dnaComplement("TCGA"));  // AGCT
    }

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
                case 'C':
                    complement.append('G');
                    break;
                case 'G':
                    complement.append('C');
                    break;
            }
        }
        return complement.toString();
    }
}