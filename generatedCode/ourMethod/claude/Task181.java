package ourMethod.claude;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    static class BankAccount {
        private final String accountId;
        private double balance;
        private boolean isActive;
        private final ReentrantLock lock;

        public BankAccount(String accountId, double initialBalance) {
            if (accountId == null || accountId.trim().isEmpty()) {
                throw new IllegalArgumentException("Account ID cannot be null or empty");
            }
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Initial balance cannot be negative");
            }
            this.accountId = accountId;
            this.balance = initialBalance;
            this.isActive = true;
            this.lock = new ReentrantLock();
        }

        public boolean deposit(double amount) {
            if (!isActive) {
                return false;
            }
            if (amount <= 0) {
                return false;
            }
            
            lock.lock();
            try {
                if (!isActive) {
                    return false;
                }
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean withdraw(double amount) {
            if (!isActive) {
                return false;
            }
            if (amount <= 0) {
                return false;
            }
            
            lock.lock();
            try {
                if (!isActive || balance < amount) {
                    return false;
                }
                balance -= amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean close() {
            lock.lock();
            try {
                if (!isActive) {
                    return false;
                }
                isActive = false;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public double getBalance() {
            lock.lock();
            try {
                if (!isActive) {
                    throw new IllegalStateException("Account is closed");
                }
                return balance;
            } finally {
                lock.unlock();
            }
        }
    }

    private static final ConcurrentHashMap<String, BankAccount> accounts = new ConcurrentHashMap<>();

    public static boolean openAccount(String accountId, double initialBalance) {
        if (accountId == null || initialBalance < 0) {
            return false;
        }
        return accounts.putIfAbsent(accountId, new BankAccount(accountId, initialBalance)) == null;
    }

    public static void main(String[] args) {
        // Test case 1: Open account
        System.out.println("Test 1: " + openAccount("ACC1", 1000.0));  // true

        // Test case 2: Deposit
        BankAccount acc1 = accounts.get("ACC1");
        System.out.println("Test 2: " + acc1.deposit(500.0));  // true
        System.out.println("Balance: " + acc1.getBalance());   // 1500.0

        // Test case 3: Withdraw
        System.out.println("Test 3: " + acc1.withdraw(200.0)); // true
        System.out.println("Balance: " + acc1.getBalance());   // 1300.0

        // Test case 4: Close account
        System.out.println("Test 4: " + acc1.close());        // true

        // Test case 5: Operation on closed account
        try {
            System.out.println("Test 5: " + acc1.deposit(100.0)); // false
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
