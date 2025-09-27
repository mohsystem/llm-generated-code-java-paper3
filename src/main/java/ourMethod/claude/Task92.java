package ourMethod.claude;

public class Task92 {
    private static final int MAX_COUNTER = 5;
    private static volatile int currentCounter = 0;
    private static final Object lock = new Object();

    static class Worker implements Runnable {
        private final String threadName;

        public Worker(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentCounter >= MAX_COUNTER) {
                        break;
                    }
                    currentCounter++;
                    System.out.println(threadName + " accessing counter. Current value: " + currentCounter);
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
        // Test case 1: Create and start 3 threads
        Thread t1 = new Thread(new Worker("Thread-1"));
        Thread t2 = new Thread(new Worker("Thread-2"));
        Thread t3 = new Thread(new Worker("Thread-3"));
        t1.start();
        t2.start();
        t3.start();

        // Test case 2: Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Test case 3: Reset and create 2 threads
        currentCounter = 0;
        Thread t4 = new Thread(new Worker("Thread-4"));
        Thread t5 = new Thread(new Worker("Thread-5"));
        t4.start();
        t5.start();

        // Test case 4: Wait for second batch to complete
        try {
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Test case 5: Verify final counter value
        System.out.println("Final counter value: " + currentCounter);
    }
}
