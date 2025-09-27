package ZeroShot.gemini;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Task189 {

    class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSem, evenSem, oddSem;

        public ZeroEvenOdd(int n) {
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
    }

    public static void main(String[] args) {
        Task189 task = new Task189();

        // Test cases
        task.test(2);
        task.test(5);
        task.test(1);
        task.test(3);
        task.test(4);


    }
    private void test(int n) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
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

        System.out.println("Output for n = " + n + ": " + sb.toString());
    }
}