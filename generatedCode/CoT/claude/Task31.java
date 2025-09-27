package CoT.claude;

public class Task31 {
    public static String makeComplement(String dna) {
        if(dna == null || dna.isEmpty()) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        for(char c : dna.toCharArray()) {
            switch(c) {
                case 'A': result.append('T'); break;
                case 'T': result.append('A'); break;
                case 'C': result.append('G'); break;
                case 'G': result.append('C'); break;
                default: result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(makeComplement("ATTGC")); // Should print: TAACG
        System.out.println(makeComplement("GTAT")); // Should print: CATA
        System.out.println(makeComplement("AAAA")); // Should print: TTTT
        System.out.println(makeComplement("GCGC")); // Should print: CGCG
        System.out.println(makeComplement("TATA")); // Should print: ATAT
    }
}
