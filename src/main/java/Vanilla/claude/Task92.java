package Vanilla.claude;

class Task92 {
    static class SharedResource {
        private int currentCounter = 0;
        private final int maxCounter;
        private final Object lock = new Object();

        public SharedResource(int maxCounter) {
            this.maxCounter = maxCounter;
        }

        public void accessResource(String threadName) {
            if (currentCounter <= maxCounter) {
                synchronized (lock) {
                    if (currentCounter <= maxCounter) {
                        currentCounter++;
                        System.out.println("Thread " + threadName + " accessing counter: " + currentCounter);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource(10);
        
        // Test case 1: Single thread
        Thread t1 = new Thread(() -> resource.accessResource("T1"));
        t1.start();
        
        // Test case 2: Multiple threads accessing simultaneously
        for(int i=0; i<5; i++) {
            final int num = i;
            new Thread(() -> resource.accessResource("T"+num)).start();
        }
        
        // Test case 3: Thread accessing after max limit
        SharedResource resource2 = new SharedResource(2);
        for(int i=0; i<5; i++) {
            final int num = i;
            new Thread(() -> resource2.accessResource("T"+num)).start();
        }
        
        // Test case 4: Multiple threads with sleep
        SharedResource resource3 = new SharedResource(5);
        for(int i=0; i<3; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                    resource3.accessResource("T"+num);
                } catch(InterruptedException e) {}
            }).start();
        }
        
        // Test case 5: Single thread multiple access
        SharedResource resource4 = new SharedResource(3);
        Thread t5 = new Thread(() -> {
            for(int i=0; i<4; i++) {
                resource4.accessResource("T5");
            }
        });
        t5.start();
    }
}
