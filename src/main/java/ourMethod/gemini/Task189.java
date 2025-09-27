package ourMethod.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task189 {
    private int n;
    private Semaphore zeroSem, evenSem, oddSem;
    private int current;

    public Task189(int n) {
        this.n = n;
        zeroSem = new Semaphore(1);
        evenSem = new Semaphore(0);
        oddSem = new Semaphore(0);
        current = 1;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (current % 2 == 1) {
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
            current++;
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
            current++;
        }
    }

    public static void main(String[] args) {
        test(2);
        test(5);
        test(1);
        test(3);
        test(10);
    }

    private static void test(int n) {
        Task189 zeo = new Task189(n);

        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeo.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(System.out::print);
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

        System.out.println(); // Add newline after each test case
    }
}