package ourMethod.codestral;
public class Task11 {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        double currentPopulation = p0;
        percent = percent / 100;

        while (currentPopulation < p) {
            currentPopulation = Math.floor(currentPopulation + currentPopulation * percent + aug);
            years++;
        }

        return years;
    }

    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000)); // Output: 15
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000)); // Output: 10
    }
}