package Vanilla.claude;

class Task189 {
    static class ZeroEvenOdd {
        private int n;
        private int current;
        private Object lock;
        private boolean isZeroPrinted;
        private boolean isNumberPrinted;
        
        public ZeroEvenOdd(int n) {
            this.n = n;
            this.current = 1;
            this.lock = new Object();
            this.isZeroPrinted = false;
            this.isNumberPrinted = true;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while (!isNumberPrinted) {
                        lock.wait();
                    }
                    printNumber.accept(0);
                    isZeroPrinted = true;
                    isNumberPrinted = false;
                    lock.notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                synchronized (lock) {
                    while (!isZeroPrinted || !isEven(current)) {
                        lock.wait();
                    }
                    printNumber.accept(current);
                    current++;
                    isZeroPrinted = false;
                    isNumberPrinted = true;
                    lock.notifyAll();
                }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                synchronized (lock) {
                    while (!isZeroPrinted || isEven(current)) {
                        lock.wait();
                    }
                    printNumber.accept(current);
                    current++;
                    isZeroPrinted = false;
                    isNumberPrinted = true;
                    lock.notifyAll();
                }
            }
        }
        
        private boolean isEven(int num) {
            return num % 2 == 0;
        }
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
