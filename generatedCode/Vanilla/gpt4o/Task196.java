package Vanilla.openai;
import java.util.concurrent.Semaphore;

public class Task196 {
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd1 = new ZeroEvenOdd(2);
        ZeroEvenOdd zeroEvenOdd2 = new ZeroEvenOdd(5);
        ZeroEvenOdd zeroEvenOdd3 = new ZeroEvenOdd(10);
        ZeroEvenOdd zeroEvenOdd4 = new ZeroEvenOdd(3);
        ZeroEvenOdd zeroEvenOdd5 = new ZeroEvenOdd(1);

        runTest(zeroEvenOdd1);
        runTest(zeroEvenOdd2);
        runTest(zeroEvenOdd3);
        runTest(zeroEvenOdd4);
        runTest(zeroEvenOdd5);
    }

    public static void runTest(ZeroEvenOdd zeroEvenOdd) {
        Thread threadA = new Thread(() -> {
            try {
                zeroEvenOdd.zero(Task196::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeroEvenOdd.even(Task196::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeroEvenOdd.odd(Task196::printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void printNumber(int number) {
        System.out.print(number);
    }
}

class ZeroEvenOdd {
    private int n;
    private int current = 1;
    private Semaphore zeroSem = new Semaphore(1);
    private Semaphore oddSem = new Semaphore(0);
    private Semaphore evenSem = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (current % 2 == 0) {
                evenSem.release();
            } else {
                oddSem.release();
            }
        }
    }

    public void even(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            current++;
            zeroSem.release();
        }
    }

    public void odd(java.util.function.IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            current++;
            zeroSem.release();
        }
    }
}