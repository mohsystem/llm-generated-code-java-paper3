package Vanilla.openai;
public class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final Object lock = new Object();

    static class CounterThread extends Thread {
        private final int threadId;

        public CounterThread(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (currentCounter <= maxCounter) {
                        System.out.println("Thread " + threadId + " is accessing currentCounter: " + currentCounter);
                        currentCounter++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            new CounterThread(i).start();
        }
    }
}