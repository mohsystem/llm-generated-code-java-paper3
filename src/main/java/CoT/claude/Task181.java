package CoT.claude;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    static class BankAccount {
        private final ReentrantLock lock = new ReentrantLock();
        private double balance;
        private boolean isOpen;
        private final String accountId;

        public BankAccount(String accountId, double initialBalance) {
            this.accountId = accountId;
            this.balance = initialBalance;
            this.isOpen = true;
        }

        public boolean withdraw(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    return false;
                }
                if (amount <= 0 || amount > balance) {
                    return false;
                }
                balance -= amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean deposit(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    return false;
                }
                if (amount <= 0) {
                    return false;
                }
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean close() {
            lock.lock();
            try {
                if (!isOpen) {
                    return false;
                }
                isOpen = false;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public double getBalance() {
            lock.lock();
            try {
                if (!isOpen) {
                    return -1;
                }
                return balance;
            } finally {
                lock.unlock();
            }
        }
    }

    static class Bank {
        private final ConcurrentHashMap<String, BankAccount> accounts = new ConcurrentHashMap<>();

        public boolean openAccount(String accountId, double initialBalance) {
            if (initialBalance < 0) {
                return false;
            }
            return accounts.putIfAbsent(accountId, new BankAccount(accountId, initialBalance)) == null;
        }

        public boolean closeAccount(String accountId) {
            BankAccount account = accounts.get(accountId);
            return account != null && account.close();
        }

        public boolean withdraw(String accountId, double amount) {
            BankAccount account = accounts.get(accountId);
            return account != null && account.withdraw(amount);
        }

        public boolean deposit(String accountId, double amount) {
            BankAccount account = accounts.get(accountId);
            return account != null && account.deposit(amount);
        }

        public double getBalance(String accountId) {
            BankAccount account = accounts.get(accountId);
            return account != null ? account.getBalance() : -1;
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Test case 1: Open account and deposit
        System.out.println(bank.openAccount("ACC1", 1000)); // true
        System.out.println(bank.deposit("ACC1", 500)); // true
        System.out.println(bank.getBalance("ACC1")); // 1500

        // Test case 2: Withdraw
        System.out.println(bank.withdraw("ACC1", 200)); // true
        System.out.println(bank.getBalance("ACC1")); // 1300

        // Test case 3: Close account
        System.out.println(bank.closeAccount("ACC1")); // true
        System.out.println(bank.deposit("ACC1", 100)); // false

        // Test case 4: Invalid operations
        System.out.println(bank.withdraw("ACC2", 100)); // false
        System.out.println(bank.deposit("ACC1", -100)); // false

        // Test case 5: Concurrent operations
        bank.openAccount("ACC3", 1000);
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                bank.deposit("ACC3", 10);
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 100; i++) {
                bank.withdraw("ACC3", 5);
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
        System.out.println(bank.getBalance("ACC3")); // 1500
    }
}
