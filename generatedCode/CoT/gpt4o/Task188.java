package CoT.openai;
import java.util.concurrent.Semaphore;

class Task188 {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(1);
    private Semaphore barSemaphore = new Semaphore(0);

    public Task188(int n) {
        this.n = n;
    }

    public void foo() {
        for (int i = 0; i < n; i++) {
            try {
                fooSemaphore.acquire();
                System.out.print("foo");
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
                System.out.print("bar");
                fooSemaphore.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        Task188 task1 = new Task188(1);
        Task188 task2 = new Task188(2);
        Task188 task3 = new Task188(3);
        Task188 task4 = new Task188(4);
        Task188 task5 = new Task188(5);

        runTest(task1);
        System.out.println();
        runTest(task2);
        System.out.println();
        runTest(task3);
        System.out.println();
        runTest(task4);
        System.out.println();
        runTest(task5);
        System.out.println();
    }

    private static void runTest(Task188 task) {
        Thread threadFoo = new Thread(task::foo);
        Thread threadBar = new Thread(task::bar);

        threadFoo.start();
        threadBar.start();

        try {
            threadFoo.join();
            threadBar.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}