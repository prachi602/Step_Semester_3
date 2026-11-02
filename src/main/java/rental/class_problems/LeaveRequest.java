package rental.class_problems;

import java.time.LocalDate;

public class LeaveRequest {

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;

    public LeaveRequest(Employee employee,
                        LocalDate startDate,
                        LocalDate endDate) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }

        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException(
                    "End date cannot be before start date"
            );
        }

        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = Status.PENDING;
    }

    public Employee getEmployee() {
        return employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }

    public boolean approve() {
        if (status != Status.PENDING) {
            return false;
        }

        if (!employee.canTakeLeave(startDate, endDate)) {
            return false;
        }

        status = Status.APPROVED;
        return true;
    }

    public boolean reject() {
        if (status != Status.PENDING) {
            return false;
        }

        status = Status.REJECTED;
        return true;
    }
}