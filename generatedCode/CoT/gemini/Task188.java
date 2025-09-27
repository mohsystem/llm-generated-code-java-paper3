package CoT.gemini;
import java.util.concurrent.Semaphore;

class Task188 {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public Task188(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            try {
                fooSemaphore.acquire();
                System.out.print("foo");
                barSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            try {
                barSemaphore.acquire();
                System.out.print("bar");
                fooSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
    }

    private static void test(int n) {
        Task188 fooBar = new Task188(n);
        Thread fooThread = new Thread(fooBar::foo);
        Thread barThread = new Thread(fooBar::bar);

        fooThread.start();
        barThread.start();

        try {
            fooThread.join();
            barThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}