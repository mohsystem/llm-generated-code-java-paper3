package ourMethodv2.gpt4o;
import java.util.concurrent.Semaphore;

class Task188 {
    static class FooBar {
        private int n;
        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        public FooBar(int n) {
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
    }

    public static void main(String[] args) {
        testFooBar(1);
        testFooBar(2);
        testFooBar(3);
        testFooBar(4);
        testFooBar(5);
    }

    private static void testFooBar(int n) {
        FooBar fooBar = new FooBar(n);
        Thread threadA = new Thread(() -> {
            try {
                fooBar.foo();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                fooBar.bar();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println();
    }
}