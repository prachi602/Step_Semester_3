package rental.class_problems;

public class UPIPayment implements PaymentMethod {

    private boolean paymentSuccessful;

    public UPIPayment(boolean paymentSuccessful) {
        this.paymentSuccessful = paymentSuccessful;
    }

    @Override
    public boolean processPayment(double amount) {
        if (amount <= 0) {
            return false;
        }

        return paymentSuccessful;
    }
}