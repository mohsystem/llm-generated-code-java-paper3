package ourMethod.codestral;
public class Task31 {
    public static String dnaComplement(String dna) {
        StringBuilder result = new StringBuilder();
        for (char base : dna.toCharArray()) {
            switch (base) {
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
                    throw new IllegalArgumentException("Invalid DNA base: " + base);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(dnaComplement("ATTGC")); // Output: TAACG
        System.out.println(dnaComplement("GTAT"));  // Output: CATA
    }
}