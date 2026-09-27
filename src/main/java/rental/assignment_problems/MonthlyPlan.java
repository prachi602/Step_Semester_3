package rental.assignment_problems;

public class MonthlyPlan implements MembershipPlan {

    private static final double BASE_RATE = 1000.00;

    @Override
    public String getName() {
        return "Monthly";
    }

    @Override
    public int getDurationMonths() {
        return 1;
    }

    @Override
    public double calculateFee() {
        return BASE_RATE;
    }
}
