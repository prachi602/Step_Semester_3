package oop.assignment_problems.employee_static;

public class Employeee {

    // Instance fields
    String empName;
    double salary;

    // Static field shared by all employees
    static String companyName = "Bright Horizon Technologies";

    // Static employee counter
    static int employeeCount = 0;

    public Employeee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        Employeee employee1 =
                new Employeee("Aarav", 50000);

        Employeee employee2 =
                new Employeee("Priya", 55000);

        Employeee employee3 =
                new Employeee("Rahul", 60000);

        Employeee.printCompanyInfo();
    }
}