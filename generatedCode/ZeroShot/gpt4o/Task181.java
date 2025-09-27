package ZeroShot.gpt4o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Task181 {
    private ConcurrentHashMap<String, Account> accounts = new ConcurrentHashMap<>();

    public class Account {
        private double balance;
        private boolean isClosed;
        private ReentrantLock lock = new ReentrantLock();

        public Account(double initialBalance) {
            this.balance = initialBalance;
            this.isClosed = false;
        }

        public boolean deposit(double amount) {
            lock.lock();
            try {
                if (isClosed) return false;
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public boolean withdraw(double amount) {
            lock.lock();
            try {
                if (isClosed || balance < amount) return false;
                balance -= amount;
                return true;
            } finally {
                lock.unlock();
            }
        }

        public double getBalance() {
            lock.lock();
            try {
                if (isClosed) return 0.0;
                return balance;
            } finally {
                lock.unlock();
            }
        }

        public boolean close() {
            lock.lock();
            try {
                if (isClosed) return false;
                isClosed = true;
                return true;
            } finally {
                lock.unlock();
            }
        }
    }

    public boolean openAccount(String id, double initialBalance) {
        if (accounts.containsKey(id)) return false;
        accounts.put(id, new Account(initialBalance));
        return true;
    }

    public boolean closeAccount(String id) {
        Account acc = accounts.get(id);
        if (acc != null) {
            return acc.close();
        }
        return false;
    }

    public boolean deposit(String id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            return acc.deposit(amount);
        }
        return false;
    }

    public boolean withdraw(String id, double amount) {
        Account acc = accounts.get(id);
        if (acc != null) {
            return acc.withdraw(amount);
        }
        return false;
    }

    public double getBalance(String id) {
        Account acc = accounts.get(id);
        if (acc != null) {
            return acc.getBalance();
        }
        return 0.0;
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        bank.openAccount("123", 1000);
        bank.deposit("123", 500);
        bank.withdraw("123", 200);
        bank.closeAccount("123");
        bank.withdraw("123", 100);
        bank.openAccount("124", 1500);
        bank.deposit("124", 300);
        bank.closeAccount("124");
        bank.deposit("124", 100);
    }
}