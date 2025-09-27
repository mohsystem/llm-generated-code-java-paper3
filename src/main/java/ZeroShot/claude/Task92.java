package ZeroShot.claude;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task92 {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final Lock lock = new ReentrantLock();
    
    static class Worker implements Runnable {
        private String threadName;
        
        public Worker(String name) {
            this.threadName = name;
        }
        
        @Override
        public void run() {
            while(true) {
                if(currentCounter <= maxCounter) {
                    try {
                        lock.lock();
                        if(currentCounter <= maxCounter) {
                            System.out.println(threadName + " accessing counter: " + currentCounter);
                            currentCounter++;
                        }
                    } finally {
                        lock.unlock();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test case 1: Create 3 threads
        Thread t1 = new Thread(new Worker("Thread-1"));
        Thread t2 = new Thread(new Worker("Thread-2"));
        Thread t3 = new Thread(new Worker("Thread-3"));
        t1.start();
        t2.start();
        t3.start();
        
        // Test case 2: Create 2 threads
        currentCounter = 0;
        Thread t4 = new Thread(new Worker("Thread-4"));
        Thread t5 = new Thread(new Worker("Thread-5"));
        t4.start();
        t5.start();
        
        // Test case 3: Single thread
        currentCounter = 0;
        Thread t6 = new Thread(new Worker("Thread-6"));
        t6.start();
        
        // Test case 4: 4 threads
        currentCounter = 0;
        Thread t7 = new Thread(new Worker("Thread-7"));
        Thread t8 = new Thread(new Worker("Thread-8"));
        Thread t9 = new Thread(new Worker("Thread-9"));
        Thread t10 = new Thread(new Worker("Thread-10"));
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        
        // Test case 5: 5 threads
        currentCounter = 0;
        Thread t11 = new Thread(new Worker("Thread-11"));
        Thread t12 = new Thread(new Worker("Thread-12"));
        Thread t13 = new Thread(new Worker("Thread-13"));
        Thread t14 = new Thread(new Worker("Thread-14"));
        Thread t15 = new Thread(new Worker("Thread-15"));
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
    }
}
