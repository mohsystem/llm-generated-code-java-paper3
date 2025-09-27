package ZeroShot.claude;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {
    static class BankAccount {
        private double balance;
        private boolean isActive;
        private final ReentrantLock lock;
        
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
            this.isActive = true;
            this.lock = new ReentrantLock();
        }
        
        public boolean deposit(double amount) {
            lock.lock();
            try {
                if (!isActive) return false;
                if (amount <= 0) return false;
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }
        
        public boolean withdraw(double amount) {
            lock.lock();
            try {
                if (!isActive) return false;
                if (amount <= 0) return false;
                if (balance < amount) return false;
                balance -= amount;
                return true;
            } finally {
                lock.unlock();
            }
        }
        
        public double getBalance() {
            lock.lock();
            try {
                if (!isActive) return -1;
                return balance;
            } finally {
                lock.unlock();
            }
        }
        
        public boolean closeAccount() {
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
    
    private static ConcurrentHashMap<String, BankAccount> accounts = new ConcurrentHashMap<>();
    
    public static boolean openAccount(String accountId, double initialBalance) {
        if (initialBalance < 0) return false;
        return accounts.putIfAbsent(accountId, new BankAccount(initialBalance)) == null;
    }
    
    public static boolean closeAccount(String accountId) {
        BankAccount account = accounts.get(accountId);
        return account != null && account.closeAccount();
    }
    
    public static boolean deposit(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        return account != null && account.deposit(amount);
    }
    
    public static boolean withdraw(String accountId, double amount) {
        BankAccount account = accounts.get(accountId);
        return account != null && account.withdraw(amount);
    }
    
    public static double getBalance(String accountId) {
        BankAccount account = accounts.get(accountId);
        return account != null ? account.getBalance() : -1;
    }
    
    public static void main(String[] args) {
        // Test Case 1: Open account and deposit
        System.out.println(openAccount("ACC1", 1000)); // true
        System.out.println(deposit("ACC1", 500)); // true
        System.out.println(getBalance("ACC1")); // 1500
        
        // Test Case 2: Withdraw
        System.out.println(withdraw("ACC1", 200)); // true
        System.out.println(getBalance("ACC1")); // 1300
        
        // Test Case 3: Close account and try operations
        System.out.println(closeAccount("ACC1")); // true
        System.out.println(deposit("ACC1", 100)); // false
        
        // Test Case 4: Invalid operations
        System.out.println(withdraw("ACC1", 2000)); // false
        System.out.println(deposit("ACC2", 100)); // false (non-existent account)
        
        // Test Case 5: Concurrent operations
        openAccount("ACC3", 1000);
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                deposit("ACC3", 10);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                withdraw("ACC3", 5);
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
        System.out.println(getBalance("ACC3")); // Should be 1500
    }
}
