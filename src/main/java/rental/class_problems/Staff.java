package rental.class_problems;

public abstract class Staff {

    protected String name;

    public Staff(String name) {
        this.name = name;
    }

    public abstract double calculatePay();

    public String getName() {
        return name;
    }

    public void displayPayslip() {
        System.out.printf(
                "Payslip: %s - %.0f%n",
                name, calculatePay()
        );
    }
}