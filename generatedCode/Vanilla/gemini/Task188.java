package Vanilla.gemini;
class Task188 {
    private int n;
    private int current;
    private Object lock = new Object();

    public Task188(int n) {
        this.n = n;
        this.current = 0;
    }

    public void foo() {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (current % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("foo");
                current++;
                lock.notifyAll();
            }

        }
    }

    public void bar() {
        synchronized (lock) {
            for (int i = 0; i < n; i++) {
                while (current % 2 != 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("bar");
                current++;
                lock.notifyAll();

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
        Task188 fb = new Task188(n);
        Thread t1 = new Thread(() -> fb.foo());
        Thread t2 = new Thread(() -> fb.bar());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}