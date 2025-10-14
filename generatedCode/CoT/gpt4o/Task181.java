package CoT.openai;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private boolean isOpen;
    private final ReentrantLock lock;

    public BankAccount() {
        this.balance = 0.0;
        this.isOpen = true;
        this.lock = new ReentrantLock();
    }

    public boolean deposit(double amount) {
        lock.lock();
        try {
            if (!isOpen) return false;
            if (amount < 0) return false;
            balance += amount;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean withdraw(double amount) {
        lock.lock();
        try {
            if (!isOpen) return false;
            if (amount < 0 || balance < amount) return false;
            balance -= amount;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            if (!isOpen) return -1;
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public boolean closeAccount() {
        lock.lock();
        try {
            if (!isOpen) return false;
            isOpen = false;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public boolean isOpen() {
        return isOpen;
    }
}

class Bank {
    private final ConcurrentHashMap<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new ConcurrentHashMap<>();
    }

    public int openAccount() {
        int accountId = accounts.size() + 1;
        accounts.put(accountId, new BankAccount());
        return accountId;
    }

    public BankAccount getAccount(int accountId) {
        return accounts.get(accountId);
    }
}

public class Task181 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        int acc1 = bank.openAccount();
        int acc2 = bank.openAccount();
        int acc3 = bank.openAccount();

        BankAccount account1 = bank.getAccount(acc1);
        BankAccount account2 = bank.getAccount(acc2);
        BankAccount account3 = bank.getAccount(acc3);

        account1.deposit(1000);
        account2.deposit(500);

        System.out.println("Account 1 Balance: " + account1.getBalance());
        System.out.println("Account 2 Balance: " + account2.getBalance());
        System.out.println("Account 3 Balance: " + account3.getBalance());

        account1.withdraw(100);
        account2.withdraw(1000); // should fail
        account3.deposit(200);

        System.out.println("Account 1 Balance after withdrawal: " + account1.getBalance());
        System.out.println("Account 2 Balance after withdrawal: " + account2.getBalance());
        System.out.println("Account 3 Balance after deposit: " + account3.getBalance());

        account3.closeAccount();
        System.out.println("Account 3 closed: " + !account3.isOpen());

        System.out.println("Account 3 Balance after closure attempt: " + account3.getBalance());
        System.out.println("Deposit to closed account 3: " + account3.deposit(100)); // should fail
    }
}