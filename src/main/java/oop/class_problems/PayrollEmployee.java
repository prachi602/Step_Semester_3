package oop.class_problems;

public class PayrollEmployee {

    private String employeeId;
    private double salary;

    // Constructor
    public PayrollEmployee(String employeeId, double salary) {
        this.employeeId = employeeId;
        this.salary = salary;
    }

    // Raise salary using this to resolve the naming clash
    public void raiseSalary(double salary) {
        this.salary = this.salary + salary;
    }

    public void printSalary() {
        System.out.println(
                employeeId + " | Final Salary: Rs " + salary
        );
    }

    public static void main(String[] args) {

        String[] employeeIds = {
                "E-101",
                "E-102",
                "E-103",
                "E-104"
        };

        double[] salaries = {
                40000,
                55000,
                62000,
                48000
        };

        double bonus = 5000;

        PayrollEmployee[] employees =
                new PayrollEmployee[employeeIds.length];

        // Create employees
        for (int i = 0; i < employees.length; i++) {
            employees[i] =
                    new PayrollEmployee(employeeIds[i], salaries[i]);
        }

        // Give every employee the same bonus in one pass
        for (PayrollEmployee employee : employees) {
            employee.raiseSalary(bonus);
            employee.printSalary();
        }
    }
}