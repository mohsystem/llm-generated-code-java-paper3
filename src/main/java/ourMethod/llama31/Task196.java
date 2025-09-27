package ourMethod.llama31;
import java.util.concurrent.Semaphore;

public class Task196 {
    private int n;
    private Semaphore zeroSem = new Semaphore(1);
    private Semaphore evenSem = new Semaphore(0);
    private Semaphore oddSem = new Semaphore(0);

    public Task196(int n) {
        this.n = n;
    }

    public void zero(IntConsumer2 printNumber) throws InterruptedException {
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

    public void even(IntConsumer2 printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public void odd(IntConsumer2 printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task196 zeroEvenOdd = new Task196(5);
        IntConsumer2 printNumber = System.out::println;

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
    }
}

interface IntConsumer2 {
    void accept(int value);
}