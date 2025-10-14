package Vanilla.openai;
import java.util.concurrent.Semaphore;

public class Task189 {

    static class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSem = new Semaphore(1);
        private Semaphore oddSem = new Semaphore(0);
        private Semaphore evenSem = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSem.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    oddSem.release();
                } else {
                    evenSem.release();
                }
            }
        }

        public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSem.acquire();
                printNumber.accept(i);
                zeroSem.release();
            }
        }

        public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSem.acquire();
                printNumber.accept(i);
                zeroSem.release();
            }
        }
    }

    public static void main(String[] args) {
        java.util.function.IntConsumer printNumber = System.out::print;

        ZeroEvenOdd instance1 = new ZeroEvenOdd(2);
        ZeroEvenOdd instance2 = new ZeroEvenOdd(5);

        Thread t1 = new Thread(() -> {
            try {
                instance1.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                instance1.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                instance1.odd(printNumber);
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

        Thread t4 = new Thread(() -> {
            try {
                instance2.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t5 = new Thread(() -> {
            try {
                instance2.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t6 = new Thread(() -> {
            try {
                instance2.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t4.start();
        t5.start();
        t6.start();

        try {
            t4.join();
            t5.join();
            t6.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}