package CoT.llama31;
class FooBar {
    private int n;
    private final Object lock = new Object();
    private boolean fooCalled = false;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooCalled) {
                    lock.wait();
                }
                printFoo.run();
                fooCalled = true;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!fooCalled) {
                    lock.wait();
                }
                printBar.run();
                fooCalled = false;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        Thread threadA = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
    }
}