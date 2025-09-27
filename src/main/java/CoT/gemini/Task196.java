package CoT.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task196 {
    private int n;
    private Semaphore zeroSem, evenSem, oddSem;

    public Task196(int n) {
        this.n = n;
        zeroSem = new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
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

    public static void main(String[] args) {
        // Test cases
        // Due to the multithreaded nature, the output may not be in order if printed directly.
        // Instead, we use a StringBuilder to collect the output from each thread. 
        
    }
}