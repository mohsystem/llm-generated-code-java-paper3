package ourMethod.llama31;
class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final Object lock = new Object();

    public static void incrementCounter(int threadId) {
        synchronized (lock) {
            if (currentCounter <= maxCounter) {
                currentCounter++;
                System.out.println("Thread " + threadId + " is accessing the currentCounter: " + currentCounter);
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            int threadId = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    incrementCounter(threadId);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}