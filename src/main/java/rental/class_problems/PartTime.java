package rental.class_problems;

public class PartTime extends Staff {

    private int hours;
    private double rate;

    public PartTime(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        return hours * rate;
    }
}