package rental.class_problems;

import java.time.LocalDate;

public abstract class Employee {
    private String employeeId;
    private String name;

    public Employee(String employeeId, String name) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be blank");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be blank");
        }

        this.employeeId = employeeId;
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public abstract boolean canTakeLeave(LocalDate startDate, LocalDate endDate);
}