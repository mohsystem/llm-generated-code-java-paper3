package ourMethod.gpt4o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {
    static class BankAccount {
        private final ReentrantLock lock = new ReentrantLock();
        private double balance;
        private boolean isOpen;

        public BankAccount() {
            this.balance = 0.0;
            this.isOpen = true;
        }

        public boolean deposit(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    return false;
                }
                if (amount < 0) {
                    throw new IllegalArgumentException("Amount must be positive");
                }
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean withdraw(double amount) {
            lock.lock();
            try {
                if (!isOpen) {
                    return false;
                }
                if (amount < 0 || amount > balance) {
                    throw new IllegalArgumentException("Invalid amount");
                }
                balance -= amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public double getBalance() {
            lock.lock();
            try {
                if (!isOpen) {
                    throw new IllegalStateException("Account is closed");
                }
                return balance;
            } finally {
                lock.unlock();
            }
        }

        public boolean closeAccount() {
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
    }

    static class Bank {
        private final ConcurrentHashMap<Integer, BankAccount> accounts = new ConcurrentHashMap<>();
        private int accountCounter = 0;

        public int openAccount() {
            BankAccount account = new BankAccount();
            int accountId = ++accountCounter;
            accounts.put(accountId, account);
            return accountId;
        }

        public boolean closeAccount(int accountId) {
            BankAccount account = accounts.get(accountId);
            if (account != null) {
                return account.closeAccount();
            }
            return false;
        }

        public boolean deposit(int accountId, double amount) {
            BankAccount account = accounts.get(accountId);
            if (account != null) {
                return account.deposit(amount);
            }
            return false;
        }

        public boolean withdraw(int accountId, double amount) {
            BankAccount account = accounts.get(accountId);
            if (account != null) {
                return account.withdraw(amount);
            }
            return false;
        }

        public double getBalance(int accountId) {
            BankAccount account = accounts.get(accountId);
            if (account != null) {
                return account.getBalance();
            }
            throw new IllegalArgumentException("Invalid account ID");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        
        // Test cases
        int acc1 = bank.openAccount();
        int acc2 = bank.openAccount();
        int acc3 = bank.openAccount();
        int acc4 = bank.openAccount();
        int acc5 = bank.openAccount();

        System.out.println("Acc1 Deposit 100: " + bank.deposit(acc1, 100));
        System.out.println("Acc2 Deposit 200: " + bank.deposit(acc2, 200));
        System.out.println("Acc1 Withdraw 50: " + bank.withdraw(acc1, 50));
        System.out.println("Acc1 Balance: " + bank.getBalance(acc1));
        System.out.println("Close Acc3: " + bank.closeAccount(acc3));
        System.out.println("Acc3 Withdraw 50: " + bank.withdraw(acc3, 50)); // Should fail
    }
}