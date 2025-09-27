package Vanilla.llama31;
class Task92 {
    private static class Counter {
        private int currentCounter;
        private final int maxCounter;
        private final Object lock = new Object();

        public Counter(int maxCounter) {
            this.maxCounter = maxCounter;
        }

        public void incrementAndPrint(int threadId) {
            synchronized (lock) {
                if (currentCounter <= maxCounter) {
                    currentCounter++;
                    System.out.println("Thread " + threadId + " is accessing currentCounter: " + currentCounter);
                }
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter(5);
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> counter.incrementAndPrint(threadId));
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