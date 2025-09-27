package CoT.claude;

public class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final Object lock = new Object();

    static class CounterThread extends Thread {
        private final String threadName;
        
        public CounterThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentCounter >= maxCounter) {
                        break;
                    }
                    currentCounter++;
                    System.out.println("Thread " + threadName + " accessing counter: " + currentCounter);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1: Create 3 threads
        Thread t1 = new CounterThread("T1");
        Thread t2 = new CounterThread("T2");
        Thread t3 = new CounterThread("T3");
        t1.start();
        t2.start();
        t3.start();

        // Test case 2: Wait for threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Reset counter for next test
        currentCounter = 0;

        // Test case 3: Create 5 threads
        Thread[] threads = new Thread[5];
        for(int i = 0; i < 5; i++) {
            threads[i] = new CounterThread("Thread-" + i);
            threads[i].start();
        }

        // Test case 4: Wait for all 5 threads
        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Test case 5: Final counter value check
        System.out.println("Final counter value: " + currentCounter);
    }
}
