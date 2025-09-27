package ourMethod.claude;

public class Task31 {
    public static String makeComplement(String dna) {
        if (dna == null || dna.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder(dna.length());
        
        for (char c : dna.toCharArray()) {
            switch (c) {
                case 'A':
                    result.append('T');
                    break;
                case 'T':
                    result.append('A');
                    break;
                case 'C':
                    result.append('G');
                    break;
                case 'G':
                    result.append('C');
                    break;
                default:
                    throw new IllegalArgumentException("Invalid DNA string");
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(makeComplement("ATTGC")); // Expected: TAACG
        System.out.println(makeComplement("GTAT")); // Expected: CATA
        System.out.println(makeComplement("AAAA")); // Expected: TTTT
        System.out.println(makeComplement("GCGC")); // Expected: CGCG
        System.out.println(makeComplement("ATCG")); // Expected: TAGC
    }
}
