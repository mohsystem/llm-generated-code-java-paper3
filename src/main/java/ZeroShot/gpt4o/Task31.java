package ZeroShot.gpt4o;
public class Task31 {
    public static String dnaComplement(String dna) {
        StringBuilder complement = new StringBuilder();
        for (char nucleotide : dna.toCharArray()) {
            switch (nucleotide) {
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
    
    public static void main(String[] args) {
        System.out.println(dnaComplement("ATTGC")); // TAACG
        System.out.println(dnaComplement("GTAT"));  // CATA
        System.out.println(dnaComplement("GCGC"));  // CGCG
        System.out.println(dnaComplement("TACG"));  // ATGC
        System.out.println(dnaComplement("ATAT"));  // TATA
    }
}