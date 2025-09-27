package ourMethod.gpt4o;
import java.util.concurrent.Semaphore;

public class Task188 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1);
        fooBar.runTestCases();
    }

    static class FooBar {
        private int n;
        private Semaphore fooSemaphore = new Semaphore(1);
        private Semaphore barSemaphore = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                fooSemaphore.acquire();
                printFoo.run();
                barSemaphore.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                barSemaphore.acquire();
                printBar.run();
                fooSemaphore.release();
            }
        }

        public void runTestCases() {
            Thread threadA = new Thread(() -> {
                try {
                    foo(() -> System.out.print("foo"));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            Thread threadB = new Thread(() -> {
                try {
                    bar(() -> System.out.print("bar"));
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
        }
    }
}