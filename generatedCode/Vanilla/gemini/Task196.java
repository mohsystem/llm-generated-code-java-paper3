package Vanilla.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task196 {

    private int n;
    private Semaphore zeroSemaphore;
    private Semaphore evenSemaphore;
    private Semaphore oddSemaphore;
    private int current;

    public Task196(int n) {
        this.n = n;
        this.zeroSemaphore = new Semaphore(1);
        this.evenSemaphore = new Semaphore(0);
        this.oddSemaphore = new Semaphore(0);
        this.current = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSemaphore.acquire();
            printNumber.accept(0);
            if (current % 2 == 1) {
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
            current++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSemaphore.acquire();
            printNumber.accept(i);
            zeroSemaphore.release();
            current++;
        }
    }

    public static void main(String[] args) {
        test(2);
        test(5);
        test(1);
        test(3);
        test(4);
    }

    private static void test(int n) {
        Task196 zeroEvenOdd = new Task196(n);
        StringBuilder sb = new StringBuilder();
        IntConsumer printNumber = sb::append;

        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }
}