package ZeroShot.claude;

class Task188 {
    private int n;
    private volatile int state = 0;
    private final Object lock = new Object();

    public Task188(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (state != 0) {
                    lock.wait();
                }
                System.out.print("foo");
                state = 1;
                lock.notifyAll();
            }
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (state != 1) {
                    lock.wait();
                }
                System.out.print("bar");
                state = 0;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        int[] testCases = {1, 2, 3, 4, 5};
        
        for (int test : testCases) {
            System.out.println("\\nTest case n = " + test + ":");
            Task188 fooBar = new Task188(test);
            
            Thread threadA = new Thread(() -> {
                try {
                    fooBar.foo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            Thread threadB = new Thread(() -> {
                try {
                    fooBar.bar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            
            threadA.start();
            threadB.start();
            
            try {
                threadA.join();
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
