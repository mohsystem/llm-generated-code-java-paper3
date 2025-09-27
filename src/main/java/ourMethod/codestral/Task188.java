package ourMethod.codestral;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class FooBar {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;
    private AtomicInteger counter;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1);
        this.barSemaphore = new Semaphore(0);
        this.counter = new AtomicInteger(0);
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            try {
                fooSemaphore.acquire();
                print("foo");
                barSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void bar() {
        for (int i = 0; i < n; i++) {
            try {
                barSemaphore.acquire();
                print("bar");
                fooSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void print(String s) {
        System.out.print(s);
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);

        Thread threadA = new Thread(() -> fooBar.foo());
        Thread threadB = new Thread(() -> fooBar.bar());

        threadA.start();
        threadB.start();
    }
}