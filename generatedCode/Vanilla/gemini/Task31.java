package Vanilla.gemini;
class Task31 {
    public String makeComplement(String dna) {
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

    public static void main(String[] args) {
        Task31 task = new Task31();
        System.out.println(task.makeComplement("ATTGC"));
        System.out.println(task.makeComplement("GTAT"));
        System.out.println(task.makeComplement("AAAA"));
        System.out.println(task.makeComplement("TTTT"));
        System.out.println(task.makeComplement("CGCG"));

    }
}