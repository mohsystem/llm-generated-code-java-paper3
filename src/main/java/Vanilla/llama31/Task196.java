package Vanilla.llama31;

import java.util.function.IntConsumer;

class Task196 {
    private int n;
    private int current = 1;

    public Task196(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                while (current % 3 != 0) wait();
                printNumber.accept(0);
                current++;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (current % 3 != 2) wait();
                printNumber.accept(i);
                current++;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (current % 3 != 1) wait();
                printNumber.accept(i);
                current++;
                notifyAll();
            }
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

        System.out.println(); // Newline after the output
    }
}