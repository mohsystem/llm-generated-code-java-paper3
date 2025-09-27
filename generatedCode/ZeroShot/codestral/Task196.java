package ZeroShot.codestral;
import java.util.function.IntConsumer;
import java.util.concurrent.Semaphore;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSem;
    private Semaphore evenSem;
    private Semaphore oddSem;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSem = new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
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

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public static void main(String[] args) {
        int[] testCases = {2, 3, 4, 5, 10};
        for (int n : testCases) {
            System.out.println("n = " + n);
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
            Thread zeroThread = new Thread(() -> {
                try {
                    zeroEvenOdd.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread evenThread = new Thread(() -> {
                try {
                    zeroEvenOdd.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread oddThread = new Thread(() -> {
                try {
                    zeroEvenOdd.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            zeroThread.start();
            evenThread.start();
            oddThread.start();
            try {
                zeroThread.join();
                evenThread.join();
                oddThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}