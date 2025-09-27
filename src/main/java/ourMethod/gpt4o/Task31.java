package ourMethod.gpt4o;
public class Task31 {
    public static String complementDNA(String dna) {
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
                default:
                    throw new IllegalArgumentException("Invalid DNA nucleotide");
            }
        }
        return complement.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(complementDNA("ATTGC")); // TAACG
        System.out.println(complementDNA("GTAT"));  // CATA
        System.out.println(complementDNA("AAAA"));  // TTTT
        System.out.println(complementDNA("CGCG"));  // GCGC
        System.out.println(complementDNA("ATCG"));  // TAGC
    }
}