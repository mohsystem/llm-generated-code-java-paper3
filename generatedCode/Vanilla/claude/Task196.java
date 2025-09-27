package Vanilla.claude;

class Task196 {
    static class ZeroEvenOdd {
        private int n;
        private int state = 0; // 0: print zero, 1: print odd, 2: print even
        private int current = 1;
        
        public ZeroEvenOdd(int n) {
            this.n = n;
        }
        
        public synchronized void zero() throws InterruptedException {
            while (current <= n) {
                while (state != 0 && current <= n) {
                    wait();
                }
                if (current <= n) {
                    System.out.print(0);
                    state = (current % 2 == 0) ? 2 : 1;
                    notifyAll();
                }
            }
        }
        
        public synchronized void even() throws InterruptedException {
            while (current <= n) {
                while (state != 2 && current <= n) {
                    wait();
                }
                if (current <= n) {
                    System.out.print(current);
                    current++;
                    state = 0;
                    notifyAll();
                }
            }
        }
        
        public synchronized void odd() throws InterruptedException {
            while (current <= n) {
                while (state != 1 && current <= n) {
                    wait();
                }
                if (current <= n) {
                    System.out.print(current);
                    current++;
                    state = 0;
                    notifyAll();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] testCases = {2, 5, 1, 3, 4};
        
        for (int n : testCases) {
            System.out.println("\\nTest case n = " + n);
            ZeroEvenOdd zeo = new ZeroEvenOdd(n);
            
            Thread t1 = new Thread(() -> {
                try {
                    zeo.zero();
                } catch (InterruptedException e) {}
            });
            
            Thread t2 = new Thread(() -> {
                try {
                    zeo.even();
                } catch (InterruptedException e) {}
            });
            
            Thread t3 = new Thread(() -> {
                try {
                    zeo.odd();
                } catch (InterruptedException e) {}
            });
            
            t1.start();
            t2.start();
            t3.start();
            
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {}
        }
    }
}
