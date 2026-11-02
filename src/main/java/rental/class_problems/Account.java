package rental.class_problems;

public abstract class Account {

    protected String accountId;
    protected double balance;

    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);

    public void displayBalance() {
        System.out.println(accountId + " balance " + balance);
    }
}