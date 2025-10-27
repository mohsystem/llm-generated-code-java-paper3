package ZeroShot.claude;

class Task196 {
    static class ZeroEvenOdd {
        private int n;
        private volatile int state = 0;
        private final Object lock = new Object();
        
        public ZeroEvenOdd(int n) {
            this.n = n;
        }
        
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (state != 0) {
                        lock.wait();
                    }
                    printNumber.accept(0);
                    state = (i % 2 == 0) ? 1 : 2;
                    lock.notifyAll();
                }
            }
        }
        
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                synchronized (lock) {
                    while (state != 2) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = 0;
                    lock.notifyAll();
                }
            }
        }
        
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                synchronized (lock) {
                    while (state != 1) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = 0;
                    lock.notifyAll();
                }
            }
        }
    }
    
    @FunctionalInterface
    interface IntConsumer {
        void accept(int value);
    }
    
    public static void main(String[] args) {
        int[] testCases = {2, 5, 1, 3, 4};
        
        for (int n : testCases) {
            System.out.println("Test case n = " + n);
            ZeroEvenOdd zeo = new ZeroEvenOdd(n);
            
            Thread threadA = new Thread(() -> {
                try {
                    zeo.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread threadB = new Thread(() -> {
                try {
                    zeo.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread threadC = new Thread(() -> {
                try {
                    zeo.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            threadA.start();
            threadB.start();
            threadC.start();
            
            try {
                threadA.join();
                threadB.join();
                threadC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
        }
    }
}
