package ZeroShot.gemini;
import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private String accountId;
    private BigDecimal balance;
    private boolean isOpen;
    private final ReentrantLock lock = new ReentrantLock();

    public Account(String accountId, BigDecimal initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.isOpen = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void close() {
        lock.lock();
        try {
            this.isOpen = false;
        } finally {
            lock.unlock();
        }
    }

    public BigDecimal getBalance() {
        lock.lock();
        try {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            return balance;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(BigDecimal amount) {
        lock.lock();
        try {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Deposit amount must be positive.");
            }
            balance = balance.add(amount);
        } finally {
            lock.unlock();
        }
    }


    public void withdraw(BigDecimal amount) {
        lock.lock();
        try {
            if (!isOpen) {
                throw new IllegalStateException("Account is closed.");
            }
            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be positive.");
            }
            if (balance.compareTo(amount) < 0) {
                throw new IllegalArgumentException("Insufficient funds.");
            }
            balance = balance.subtract(amount);

        } finally {
            lock.unlock();
        }
    }


}

public class Task181 {
    public static void main(String[] args) {
        Account account1 = new Account("123", new BigDecimal("1000.00"));

        // Test case 1: Deposit
        account1.deposit(new BigDecimal("500.00"));
        System.out.println("Balance after deposit: " + account1.getBalance());

        // Test case 2: Withdrawal
        account1.withdraw(new BigDecimal("200.00"));
        System.out.println("Balance after withdrawal: " + account1.getBalance());

        // Test case 3: Close account
        account1.close();
        System.out.println("Account closed: " + !account1.isOpen());

        // Test case 4: Attempt deposit on closed account
        try {
            account1.deposit(new BigDecimal("100.00"));
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }



        // Test case 5: Attempt withdrawal on closed account
        try {
            account1.withdraw(new BigDecimal("50.00"));
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

    }
}