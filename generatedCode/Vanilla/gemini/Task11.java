package Vanilla.gemini;
class Task11 {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        double population = p0;
        while (population < p) {
            population = population + population * (percent / 100) + aug;
            population = Math.floor(population);
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000)); // Expected output: 15
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000)); // Expected output: 10
        System.out.println(nbYear(1000, 2, 50, 1200)); // Expected output: 3
        System.out.println(nbYear(1000, 2, -50, 1200)); // Expected output: 5
        System.out.println(nbYear(1500, 5, -100, 5000)); // Expected output: 51

    }
}