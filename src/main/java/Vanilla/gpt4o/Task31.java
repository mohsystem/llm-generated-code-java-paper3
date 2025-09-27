package Vanilla.gpt4o;
public class Task31 {
    public static String DNAStrand(String dna) {
        StringBuilder complementaryStrand = new StringBuilder();
        for (char nucleotide : dna.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    complementaryStrand.append('T');
                    break;
                case 'T':
                    complementaryStrand.append('A');
                    break;
                case 'C':
                    complementaryStrand.append('G');
                    break;
                case 'G':
                    complementaryStrand.append('C');
                    break;
            }
        }
        return complementaryStrand.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(DNAStrand("ATTGC")); // Output: "TAACG"
        System.out.println(DNAStrand("GTAT"));  // Output: "CATA"
        System.out.println(DNAStrand("AGTC"));  // Output: "TCAG"
        System.out.println(DNAStrand("AAAA"));  // Output: "TTTT"
        System.out.println(DNAStrand("CGCG"));  // Output: "GCGC"
    }
}