package Vanilla.llama31;
class Task188 {
    private int n;
    private boolean fooCalled = true;

    public Task188(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!fooCalled) {
                    wait();
                }
                printFoo.run();
                fooCalled = false;
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (fooCalled) {
                    wait();
                }
                printBar.run();
                fooCalled = true;
                notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task188 task = new Task188(5);
        Thread threadA = new Thread(() -> {
            try {
                task.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                task.bar(() -> System.out.print("bar"));
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