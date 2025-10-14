package ZeroShot.openai;
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

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire();
            System.out.print("foo");
            barSemaphore.release();
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            System.out.print("bar");
            fooSemaphore.release();
        }
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 5, 10};
        for (int n : testCases) {
            Task188 fooBar = new Task188(n);
            Thread threadA = new Thread(() -> {
                try {
                    fooBar.foo();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            Thread threadB = new Thread(() -> {
                try {
                    fooBar.bar();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threadA.start();
            threadB.start();
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println();
        }
    }
}