package rental.assignment_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Assignment {

    private String title;
    private int maxMarks;
    private LocalDate dueDate;

    public Assignment(
            String title,
            int maxMarks,
            LocalDate dueDate) {

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Assignment title cannot be blank"
            );
        }

        if (maxMarks <= 0) {
            throw new IllegalArgumentException(
                    "Maximum marks must be positive"
            );
        }

        if (dueDate == null) {
            throw new IllegalArgumentException(
                    "Due date cannot be null"
            );
        }

        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public long getLateDays(LocalDate submissionDate) {

        if (!submissionDate.isAfter(dueDate)) {
            return 0;
        }

        return ChronoUnit.DAYS.between(
                dueDate,
                submissionDate
        );
    }

    public abstract double applyLatePenalty(
            double awardedMarks,
            long lateDays
    );
}