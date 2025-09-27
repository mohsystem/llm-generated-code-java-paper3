package ourMethod.codestral;
public class Task196 {
    public static void main(String[] args) {
        int n = 5;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);

        Thread threadA = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}