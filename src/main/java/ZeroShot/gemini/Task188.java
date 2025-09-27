package ZeroShot.gemini;
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
        try {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                System.out.print("foo");
                barSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void bar() {
        try {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                System.out.print("bar");
                fooSemaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task188 fb1 = new Task188(1);
        Thread t1 = new Thread(() -> fb1.foo());
        Thread t2 = new Thread(() -> fb1.bar());
        t1.start();
        t2.start();


        Task188 fb2 = new Task188(2);
        Thread t3 = new Thread(() -> fb2.foo());
        Thread t4 = new Thread(() -> fb2.bar());
        t3.start();
        t4.start();

        Task188 fb3 = new Task188(3);
        Thread t5 = new Thread(() -> fb3.foo());
        Thread t6 = new Thread(() -> fb3.bar());
        t5.start();
        t6.start();

        Task188 fb4 = new Task188(4);
        Thread t7 = new Thread(() -> fb4.foo());
        Thread t8 = new Thread(() -> fb4.bar());
        t7.start();
        t8.start();

        Task188 fb5 = new Task188(5);
        Thread t9 = new Thread(() -> fb5.foo());
        Thread t10 = new Thread(() -> fb5.bar());
        t9.start();
        t10.start();
    }
}