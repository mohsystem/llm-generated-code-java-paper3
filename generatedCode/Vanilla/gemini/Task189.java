package Vanilla.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task189 {

    class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSem, evenSem, oddSem;
        private int current;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.zeroSem = new Semaphore(1);
            this.evenSem = new Semaphore(0);
            this.oddSem = new Semaphore(0);
            this.current = 1;
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
                current++;
                zeroSem.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSem.acquire();
                printNumber.accept(i);
                current++;
                zeroSem.release();
            }
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
        Task189 task = new Task189();
        ZeroEvenOdd zeo = task.new ZeroEvenOdd(n);
        StringBuilder sb = new StringBuilder();
        IntConsumer printNumber = sb::append;

        Thread t1 = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                zeo.odd(printNumber);
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

        System.out.println("n = " + n + ", Output: " + sb.toString());


    }
}