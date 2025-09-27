package CoT.llama31;
import java.util.concurrent.Semaphore;

class ZeroEvenOdd {
    private int n;
    private final Semaphore zeroSem = new Semaphore(1);
    private final Semaphore evenSem = new Semaphore(0);
    private final Semaphore oddSem = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
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
}

class Task196 {
    public static void main(String[] args) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(5);
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(i -> System.out.print(i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(i -> System.out.print(i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(i -> System.out.print(i));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
}

interface IntConsumer {
    void accept(int value);
}