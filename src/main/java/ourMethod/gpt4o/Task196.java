package ourMethod.gpt4o;
import java.util.concurrent.Semaphore;

public class Task196 {
    static class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSem = new Semaphore(1);
        private Semaphore evenSem = new Semaphore(0);
        private Semaphore oddSem = new Semaphore(0);
        private int current = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSem.acquire();
                printNumber.accept(0);
                if (current % 2 == 0) {
                    evenSem.release();
                } else {
                    oddSem.release();
                }
            }
        }

        public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSem.acquire();
                printNumber.accept(current++);
                zeroSem.release();
            }
        }

        public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSem.acquire();
                printNumber.accept(current++);
                zeroSem.release();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] testCases = {2, 3, 5, 6, 8};
        for (int n : testCases) {
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
            java.util.function.IntConsumer printNumber = System.out::print;

            Thread threadA = new Thread(() -> {
                try {
                    zeroEvenOdd.zero(printNumber);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread threadB = new Thread(() -> {
                try {
                    zeroEvenOdd.even(printNumber);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread threadC = new Thread(() -> {
                try {
                    zeroEvenOdd.odd(printNumber);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            threadA.start();
            threadB.start();
            threadC.start();

            threadA.join();
            threadB.join();
            threadC.join();
            System.out.println();
        }
    }
}