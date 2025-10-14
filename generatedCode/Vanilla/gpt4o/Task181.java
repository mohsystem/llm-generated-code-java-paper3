package Vanilla.openai;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Task181 {
    private ConcurrentHashMap<Integer, Account> accounts = new ConcurrentHashMap<>();
    private int accountIdCounter = 0;
    private Lock lock = new ReentrantLock();

    class Account {
        private int id;
        private double balance;
        private boolean isOpen;
        private Lock accountLock = new ReentrantLock();

        public Account(int id) {
            this.id = id;
            this.balance = 0.0;
            this.isOpen = true;
        }

        public boolean deposit(double amount) {
            accountLock.lock();
            try {
                if (!isOpen) return false;
                if (amount < 0) return false;
                balance += amount;
                return true;
            } finally {
                accountLock.unlock();
            }
        }

        public boolean withdraw(double amount) {
            accountLock.lock();
            try {
                if (!isOpen || amount < 0 || balance < amount) return false;
                balance -= amount;
                return true;
            } finally {
                accountLock.unlock();
            }
        }

        public double getBalance() {
            accountLock.lock();
            try {
                return isOpen ? balance : -1;
            } finally {
                accountLock.unlock();
            }
        }

        public boolean close() {
            accountLock.lock();
            try {
                if (!isOpen) return false;
                isOpen = false;
                return true;
            } finally {
                accountLock.unlock();
            }
        }
    }

    public int openAccount() {
        lock.lock();
        try {
            int accountId = accountIdCounter++;
            accounts.put(accountId, new Account(accountId));
            return accountId;
        } finally {
            lock.unlock();
        }
    }

    public boolean closeAccount(int accountId) {
        Account account = accounts.get(accountId);
        if (account == null) return false;
        return account.close();
    }

    public boolean deposit(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account == null) return false;
        return account.deposit(amount);
    }

    public boolean withdraw(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account == null) return false;
        return account.withdraw(amount);
    }

    public double getBalance(int accountId) {
        Account account = accounts.get(accountId);
        if (account == null) return -1;
        return account.getBalance();
    }

    public static void main(String[] args) {
        Task181 bank = new Task181();
        
        int acc1 = bank.openAccount();
        int acc2 = bank.openAccount();
        
        System.out.println(bank.deposit(acc1, 1000)); // true
        System.out.println(bank.withdraw(acc1, 500)); // true
        System.out.println(bank.getBalance(acc1)); // 500.0
        
        System.out.println(bank.deposit(acc2, 200)); // true
        System.out.println(bank.getBalance(acc2)); // 200.0
        
        System.out.println(bank.closeAccount(acc1)); // true
        System.out.println(bank.withdraw(acc1, 100)); // false
        
        System.out.println(bank.getBalance(acc1)); // -1
    }
}