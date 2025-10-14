package Vanilla.openai;
import java.util.concurrent.Semaphore;

public class Task188 {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public Task188(int n) {
        this.n = n;
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
        Task188 example1 = new Task188(1);
        Task188 example2 = new Task188(2);
        Task188 example3 = new Task188(3);
        Task188 example4 = new Task188(4);
        Task188 example5 = new Task188(5);

        Runnable fooRunnable1 = () -> {
            try {
                example1.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barRunnable1 = () -> {
            try {
                example1.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(fooRunnable1).start();
        new Thread(barRunnable1).start();

        Runnable fooRunnable2 = () -> {
            try {
                example2.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barRunnable2 = () -> {
            try {
                example2.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(fooRunnable2).start();
        new Thread(barRunnable2).start();

        Runnable fooRunnable3 = () -> {
            try {
                example3.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barRunnable3 = () -> {
            try {
                example3.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(fooRunnable3).start();
        new Thread(barRunnable3).start();

        Runnable fooRunnable4 = () -> {
            try {
                example4.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barRunnable4 = () -> {
            try {
                example4.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(fooRunnable4).start();
        new Thread(barRunnable4).start();

        Runnable fooRunnable5 = () -> {
            try {
                example5.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable barRunnable5 = () -> {
            try {
                example5.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        new Thread(fooRunnable5).start();
        new Thread(barRunnable5).start();
    }
}