package ZeroShot.llama31;
import java.util.concurrent.Semaphore;

public class Task196 {
    private int n;
    private final Semaphore zeroSemaphore = new Semaphore(1);
    private final Semaphore evenSemaphore = new Semaphore(0);
    private final Semaphore oddSemaphore = new Semaphore(0);

    public Task196(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                evenSemaphore.release();
            } else {
                oddSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task196 zeroEvenOdd = new Task196(5);
        IntConsumer printNumber = System.out::print;
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

    interface IntConsumer {
        void accept(int x);
    }
}