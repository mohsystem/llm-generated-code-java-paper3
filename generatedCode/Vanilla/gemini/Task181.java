package Vanilla.gemini;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {

    private Map<String, Account> accounts = new HashMap<>();

    public void openAccount(String accountId) {
        accounts.put(accountId, new Account());
    }

    public void closeAccount(String accountId) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.close();
        }
    }

    public void deposit(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null && account.isOpen()) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null && account.isOpen()) {
            account.withdraw(amount);
        }
    }

    public double getBalance(String accountId) {
        Account account = accounts.get(accountId);
        if (account != null && account.isOpen()) {
            return account.getBalance();
        }
        return -1; // Indicate account not found or closed
    }

    private class Account {
        private double balance = 0.0;
        private boolean open = true;
        private ReentrantLock lock = new ReentrantLock();

        public void close() {
            lock.lock();
            try {
                open = false;
            } finally {
                lock.unlock();
            }
        }

        public boolean isOpen() {
            lock.lock();
            try {
                return open;
            } finally {
                lock.unlock();
            }
        }

        public void deposit(double amount) {
            lock.lock();
            try {
                if (open) {
                    balance += amount;
                }
            } finally {
                lock.unlock();
            }
        }

        public void withdraw(double amount) {
            lock.lock();
            try {
                if (open && balance >= amount) {
                    balance -= amount;
                }
            } finally {
                lock.unlock();
            }
        }


        public double getBalance() {
            lock.lock();
            try {
                return balance;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        bank.openAccount("123");
        bank.deposit("123", 100);
        System.out.println(bank.getBalance("123")); // 100.0
        bank.withdraw("123", 50);
        System.out.println(bank.getBalance("123")); // 50.0
        bank.closeAccount("123");
        System.out.println(bank.getBalance("123")); // -1.0

        bank.openAccount("456");
        bank.deposit("456", 200);
        bank.withdraw("456", 250); // Insufficient funds, balance remains 200
        System.out.println(bank.getBalance("456")); // 200.0

        bank.openAccount("789");
        bank.deposit("789", 500);
        bank.closeAccount("789");
        bank.deposit("789", 100); // Deposit fails, account closed
        System.out.println(bank.getBalance("789")); //-1.0

        System.out.println(bank.getBalance("000")); // -1.0 Account not found

        bank.openAccount("000");
        System.out.println(bank.getBalance("000")); // 0.0
    }
}