package ourMethod.gemini;
import java.lang.StringBuilder;

class Task31 {
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
                    break; 
            }
        }
        return complement.toString();
    }

    public static void main(String[] args) {
        Task31 task31 = new Task31();

        String[] testCases = {"ATTGC", "GTAT", "A", "CG", "ATCGTA"};
        String[] expectedOutputs = {"TAACG", "CATA", "T", "GC", "TAGCAT"};

        for (int i = 0; i < testCases.length; i++) {
            String result = task31.makeComplement(testCases[i]);
            System.out.println("Input: " + testCases[i] + ", Output: " + result + ", Expected: " + expectedOutputs[i] + ", Result: " + result.equals(expectedOutputs[i]));
        }
    }
}