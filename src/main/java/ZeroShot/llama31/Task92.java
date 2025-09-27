package ZeroShot.llama31;
class Task92 {
    private static int currentCounter = 0;
    private static int maxCounter = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(Task92::accessCounter);
            threads[i].start();
        }
    }

    public static void accessCounter() {
        while (true) {
            synchronized (lock) {
                if (currentCounter <= maxCounter) {
                    currentCounter++;
                    System.out.println("Thread " + Thread.currentThread().getName() + " is accessing currentCounter: " + currentCounter);
                } else {
                    break;
                }
            }
            try {
                Thread.sleep(100); // Add a small delay to avoid rapid execution
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}