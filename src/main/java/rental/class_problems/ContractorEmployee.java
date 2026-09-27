package rental.class_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContractorEmployee extends Employee {

    public ContractorEmployee(String employeeId, String name) {
        super(employeeId, name);
    }

    @Override
    public boolean canTakeLeave(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return days <= 5;
    }
}