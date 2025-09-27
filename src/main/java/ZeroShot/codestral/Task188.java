package ZeroShot.codestral;
class FooBar {
    private int n;
    private boolean fooTurn = true;
    private Object lock = new Object();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (!fooTurn) {
                    lock.wait();
                }
                printFoo.run();
                fooTurn = false;
                lock.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooTurn) {
                    lock.wait();
                }
                printBar.run();
                fooTurn = true;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
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