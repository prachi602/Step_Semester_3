package rental.class_problems;

public class FullTime extends Staff {

    private double salary;

    public FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }
}
