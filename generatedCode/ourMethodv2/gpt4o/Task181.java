package ourMethodv2.gpt4o;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.Map;

public class Task181 {
    private Map<Integer, BankAccount> accounts = new HashMap<>();
    private ReentrantLock lock = new ReentrantLock();
    
    private class BankAccount {
        private double balance;
        private boolean isClosed;
        private ReentrantLock accountLock = new ReentrantLock();

        public BankAccount() {
            this.balance = 0.0;
            this.isClosed = false;
        }

        public boolean deposit(double amount) {
            accountLock.lock();
            try {
                if (isClosed) return false;
                balance += amount;
                return true;
            } finally {
                accountLock.unlock();
            }
        }

        public boolean withdraw(double amount) {
            accountLock.lock();
            try {
                if (isClosed || balance < amount) return false;
                balance -= amount;
                return true;
            } finally {
                accountLock.unlock();
            }
        }

        public Double getBalance() {
            accountLock.lock();
            try {
                if (isClosed) return null;
                return balance;
            } finally {
                accountLock.unlock();
            }
        }

        public boolean closeAccount() {
            accountLock.lock();
            try {
                if (isClosed) return false;
                isClosed = true;
                return true;
            } finally {
                accountLock.unlock();
            }
        }
    }

    public int openAccount() {
        lock.lock();
        try {
            int accountId = accounts.size() + 1;
            accounts.put(accountId, new BankAccount());
            return accountId;
        } finally {
            lock.unlock();
        }
    }

    public boolean closeAccount(int accountId) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountId);
            return account != null && account.closeAccount();
        } finally {
            lock.unlock();
        }
    }

    public boolean deposit(int accountId, double amount) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountId);
            return account != null && account.deposit(amount);
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(int accountId, double amount) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountId);
            return account != null && account.withdraw(amount);
        } finally {
            lock.unlock();
        }
    }

    public Double getBalance(int accountId) {
        lock.lock();
        try {
            BankAccount account = accounts.get(accountId);
            return account != null ? account.getBalance() : null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Task181 bankSystem = new Task181();

        int acc1 = bankSystem.openAccount();
        int acc2 = bankSystem.openAccount();

        System.out.println(bankSystem.deposit(acc1, 100)); // true
        System.out.println(bankSystem.withdraw(acc1, 50)); // true
        System.out.println(bankSystem.getBalance(acc1)); // 50.0
        System.out.println(bankSystem.closeAccount(acc1)); // true
        System.out.println(bankSystem.withdraw(acc1, 10)); // false

        System.out.println(bankSystem.deposit(acc2, 200)); // true
        System.out.println(bankSystem.getBalance(acc2)); // 200.0
        System.out.println(bankSystem.closeAccount(acc2)); // true
        System.out.println(bankSystem.getBalance(acc2)); // null
    }
}