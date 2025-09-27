package ZeroShot.gemini;
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
            }
        }
        return complement.toString();
    }

    public static void main(String[] args) {
        Task31 task31 = new Task31();
        System.out.println(task31.makeComplement("ATTGC"));
        System.out.println(task31.makeComplement("GTAT"));
        System.out.println(task31.makeComplement("AAAA"));
        System.out.println(task31.makeComplement("TTTT"));
        System.out.println(task31.makeComplement("CGCG"));

    }
}