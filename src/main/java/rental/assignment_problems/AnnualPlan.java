package rental.assignment_problems;

public class AnnualPlan implements MembershipPlan {

    private static final double BASE_RATE = 1000.00;

    @Override
    public String getName() {
        return "Annual";
    }

    @Override
    public int getDurationMonths() {
        return 12;
    }

    @Override
    public double calculateFee() {
        double originalFee = BASE_RATE * getDurationMonths();
        return originalFee * 0.75;
    }
}