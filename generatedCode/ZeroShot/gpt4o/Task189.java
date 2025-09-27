package ZeroShot.gpt4o;
import java.util.concurrent.Semaphore;

public class Task189 {
    static class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore oddSemaphore = new Semaphore(0);
        private Semaphore evenSemaphore = new Semaphore(0);
        private volatile int count = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(PrintNumber printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSemaphore.acquire();
                printNumber.print(0);
                if (count % 2 == 0) {
                    evenSemaphore.release();
                } else {
                    oddSemaphore.release();
                }
            }
        }

        public void even(PrintNumber printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire();
                printNumber.print(i);
                count++;
                zeroSemaphore.release();
            }
        }

        public void odd(PrintNumber printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire();
                printNumber.print(i);
                count++;
                zeroSemaphore.release();
            }
        }
    }

    interface PrintNumber {
        void print(int x);
    }

    public static void main(String[] args) {
        runTest(2);
        runTest(5);
        runTest(1);
        runTest(10);
        runTest(3);
    }

    public static void runTest(int n) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
    }
}