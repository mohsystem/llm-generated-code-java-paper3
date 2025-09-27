package CoT.llama31;
class Task92 {
    private static int currentCounter = 0;
    private static int maxCounter = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(Task92::threadMethod, "Thread-" + i);
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

    public static void threadMethod() {
        while (true) {
            synchronized (lock) {
                if (currentCounter <= maxCounter) {
                    currentCounter++;
                    System.out.println(Thread.currentThread().getName() + " is accessing currentCounter: " + currentCounter);
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(100); // Add a small delay to avoid busy-waiting
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}