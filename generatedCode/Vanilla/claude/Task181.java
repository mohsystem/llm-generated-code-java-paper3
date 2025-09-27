package Vanilla.claude;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {
    static class BankAccount {
        private double balance;
        private boolean isActive;
        private final Lock lock;
        
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
            this.isActive = true;
            this.lock = new ReentrantLock();
        }
        
        public boolean deposit(double amount) {
            if (!isActive) return false;
            if (amount <= 0) return false;
            
            lock.lock();
            try {
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }
        
        public boolean withdraw(double amount) {
            if (!isActive) return false;
            if (amount <= 0) return false;
            
            lock.lock();
            try {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }
        
        public double getBalance() {
            if (!isActive) return -1;
            lock.lock();
            try {
                return balance;
            } finally {
                lock.unlock();
            }
        }
        
        public boolean close() {
            lock.lock();
            try {
                if (!isActive) return false;
                isActive = false;
                return true;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Basic deposit and withdraw
        BankAccount acc1 = new BankAccount(1000);
        System.out.println(acc1.deposit(500));  // true
        System.out.println(acc1.getBalance());  // 1500
        System.out.println(acc1.withdraw(200)); // true
        System.out.println(acc1.getBalance());  // 1300

        // Test Case 2: Invalid operations
        System.out.println(acc1.deposit(-100)); // false
        System.out.println(acc1.withdraw(2000)); // false

        // Test Case 3: Concurrent operations
        BankAccount acc2 = new BankAccount(1000);
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                acc2.deposit(10);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                acc2.withdraw(5);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(acc2.getBalance()); // Should be 1500

        // Test Case 4: Closed account operations
        BankAccount acc3 = new BankAccount(500);
        acc3.close();
        System.out.println(acc3.deposit(100)); // false
        System.out.println(acc3.withdraw(100)); // false
        System.out.println(acc3.getBalance()); // -1

        // Test Case 5: Multiple deposits and withdrawals
        BankAccount acc4 = new BankAccount(0);
        for(int i = 0; i < 5; i++) {
            acc4.deposit(100);
            acc4.withdraw(50);
        }
        System.out.println(acc4.getBalance()); // 250
    }
}
