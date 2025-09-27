package Vanilla.llama31;
class Task189 {
    private int n;
    private int current = 1;

    public Task189(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (this) {
                while (current != 1) wait();
                printNumber.accept(0);
                current = (i % 2 == 0) ? 2 : 3;
                notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (this) {
                while (current != 2) wait();
                printNumber.accept(i);
                current = 1;
                notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (this) {
                while (current != 3) wait();
                printNumber.accept(i);
                current = 1;
                notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task189 zeroEvenOdd = new Task189(5);
        IntConsumer printNumber = System.out::print;

        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}