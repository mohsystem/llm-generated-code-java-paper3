package CoT.codestral;
import java.util.concurrent.locks.*;

public class FooBar {
    private int n;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean fooTurn = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!fooTurn) {
                    condition.await();
                }
                printFoo.run();
                fooTurn = false;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (fooTurn) {
                    condition.await();
                }
                printBar.run();
                fooTurn = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}