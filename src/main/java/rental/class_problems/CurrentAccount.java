package rental.class_problems;

public class CurrentAccount extends Account {

    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(String accountId, double balance) {
        super(accountId, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println(accountId + " balance " + balance);
        } else {
            System.out.println(accountId + " rejected: overdraft limit 5000");
        }
    }
}