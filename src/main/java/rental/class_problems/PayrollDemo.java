package rental.class_problems;

public class PayrollDemo {

    public static void main(String[] args) {

        Staff[] employees = {
                new FullTime("Asha", 50000),
                new PartTime("Ravi", 80, 300),
                new Intern("Neha", 15000)
        };

        double totalPayroll = 0;
        int topEarnerIndex = 0;

        System.out.println("PAYROLL REGISTER");
        System.out.println("----------------");

        // Generate payslips
        for (int i = 0; i < employees.length; i++) {

            employees[i].displayPayslip();

            totalPayroll += employees[i].calculatePay();

            if (employees[i].calculatePay()
                    > employees[topEarnerIndex].calculatePay()) {

                topEarnerIndex = i;
            }
        }

        // Display total payroll
        System.out.printf(
                "%nTotal Payroll: %.0f%n",
                totalPayroll
        );

        // Display highest-paid employee
        System.out.println(
                "Top Earner: "
                        + employees[topEarnerIndex].getName()
        );

    }
}