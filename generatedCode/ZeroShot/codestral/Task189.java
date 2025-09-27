package ZeroShot.codestral;
import java.util.concurrent.Semaphore;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSemaphore;
    private Semaphore oddSemaphore;
    private Semaphore evenSemaphore;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroSemaphore = new Semaphore(1);
        oddSemaphore = new Semaphore(0);
        evenSemaphore = new Semaphore(0);
    }

    // printNumber is an existing API
    // call it to output the zero
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    // printNumber is an existing API
    // call it to output the even numbers
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }

    // printNumber is an existing API
    // call it to output the odd numbers
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
        }
    }
}