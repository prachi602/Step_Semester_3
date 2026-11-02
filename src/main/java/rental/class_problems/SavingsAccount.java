package rental.class_problems;

public class SavingsAccount extends Account {

    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(String accountId, double balance) {
        super(accountId, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (balance - amount >= MIN_BALANCE) {
            balance -= amount;
            System.out.println(accountId + " balance " + balance);
        } else {
            System.out.println(accountId + " rejected: minimum balance 1000");
        }
    }
}