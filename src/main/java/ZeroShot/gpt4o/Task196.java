package ZeroShot.gpt4o;
import java.util.concurrent.Semaphore;

public class Task196 {
    public static void main(String[] args) {
        ZeroEvenOdd zeo1 = new ZeroEvenOdd(2);
        ZeroEvenOdd zeo2 = new ZeroEvenOdd(5);
        ZeroEvenOdd zeo3 = new ZeroEvenOdd(3);
        ZeroEvenOdd zeo4 = new ZeroEvenOdd(4);
        ZeroEvenOdd zeo5 = new ZeroEvenOdd(6);

        new Thread(() -> {
            try {
                zeo1.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeo1.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeo1.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Repeat similar thread creation for zeo2, zeo3, zeo4, and zeo5
    }
}

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSem = new Semaphore(1);
    private Semaphore evenSem = new Semaphore(0);
    private Semaphore oddSem = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
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

    public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }

    public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();
        }
    }
}