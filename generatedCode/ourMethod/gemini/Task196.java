package ourMethod.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task196 {

    private int n;
    private Semaphore zeroSemaphore;
    private Semaphore evenSemaphore;
    private Semaphore oddSemaphore;
    private int currentNumber;

    public Task196(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        this.evenSemaphore = new Semaphore(0);
        this.oddSemaphore = new Semaphore(0);
        this.currentNumber = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (currentNumber % 2 == 1) {
                oddSemaphore.release();
            } else {
                evenSemaphore.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
            currentNumber++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
            currentNumber++;
        }
    }


    public static void main(String[] args) throws InterruptedException {
        IntConsumer printNumber = System.out::print;

        Task196 test1 = new Task196(2);
        Thread t1_1 = new Thread(() -> {
            try {
                test1.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t1_2 = new Thread(() -> {
            try {
                test1.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t1_3 = new Thread(() -> {
            try {
                test1.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1_1.start();
        t1_2.start();
        t1_3.start();

        t1_1.join();
        t1_2.join();
        t1_3.join();
        System.out.println("");


    }
}