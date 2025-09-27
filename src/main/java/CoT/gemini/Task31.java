package CoT.gemini;
public class Task31 {

    public String makeComplement(String dna) {
        StringBuilder complement = new StringBuilder();
        for (char base : dna.toCharArray()) {
            switch (base) {
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
                    // Handle invalid input if needed
                    break;
            }
        }
        return complement.toString();
    }

    public static void main(String[] args) {
        Task31 task31 = new Task31();
        System.out.println(task31.makeComplement("ATTGC")); // Expected: TAACG
        System.out.println(task31.makeComplement("GTAT"));  // Expected: CATA
        System.out.println(task31.makeComplement("AAAA"));  // Expected: TTTT
        System.out.println(task31.makeComplement("CGCG"));  // Expected: GCGC
        System.out.println(task31.makeComplement("ATCG"));  // Expected: TAGC


    }
}