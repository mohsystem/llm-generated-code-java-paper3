package Vanilla.codestral;
import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
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
                System.out.println("bar");
                fooSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);

        Thread threadA = new Thread(() -> fooBar.foo());
        Thread threadB = new Thread(() -> fooBar.bar());

        threadA.start();
        threadB.start();
    }
}