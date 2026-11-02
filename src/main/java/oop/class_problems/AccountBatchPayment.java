package oop.class_problems;

class FeeAccount {

    protected String accountType;

    public FeeAccount(String accountType) {
        this.accountType = accountType;
    }
}

class HostelFeeAccount extends FeeAccount {

    public HostelFeeAccount() {
        super("Hostel");
    }
}

public class AccountBatchPayment {

    private static int hostelCount = 0;
    private static int dayScholarCount = 0;

    public static void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {

            System.out.println(
                    "Paid in two installments (hostel account)"
            );

            hostelCount++;

        } else {

            System.out.println(
                    "Paid in one go (day-scholar account)"
            );

            dayScholarCount++;
        }
    }

    public static void main(String[] args) {

        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount("Day Scholar"),
                new FeeAccount("Day Scholar")
        };

        double amount = 60000;

        // Process the entire batch
        for (FeeAccount account : accounts) {
            processPayment(account, amount);
        }

        // Print counts once after the batch
        System.out.println(
                "Hostel accounts processed: " + hostelCount
                        + " | Day-scholar accounts processed: "
                        + dayScholarCount
        );
    }
}