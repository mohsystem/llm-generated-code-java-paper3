package Vanilla.codestral;
public class Task31 {
    public static String makeComplement(String dna) {
        StringBuilder result = new StringBuilder();
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
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeComplement("ATTGC")); // TAACG
        System.out.println(makeComplement("GTAT")); // CATA
    }
}