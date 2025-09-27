package Vanilla.claude;

class Task188 {
    private int n;
    private boolean isFoo = true;

    public Task188(int n) {
        this.n = n;
    }

    public synchronized void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!isFoo) {
                wait();
            }
            System.out.print("foo");
            isFoo = false;
            notify();
        }
    }

    public synchronized void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (isFoo) {
                wait();
            }
            System.out.print("bar");
            isFoo = true;
            notify();
        }
    }

    public static void main(String[] args) {
        // Test cases
        int[] testCases = {1, 2, 3, 4, 5};
        
        for (int n : testCases) {
            System.out.println("\\nTest case n = " + n);
            Task188 fb = new Task188(n);
            
            Thread t1 = new Thread(() -> {
                try {
                    fb.foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread t2 = new Thread(() -> {
                try {
                    fb.bar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            t1.start();
            t2.start();
            
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
