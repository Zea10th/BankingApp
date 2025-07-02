package src;

public class BankAccount {
    private double balance;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new RuntimeException("Insufficient funds");
        }

        this.balance -= amount;
    }

    public void printBalance() {
        System.out.printf("Available: %.2f\n", this.balance);
    }
}
