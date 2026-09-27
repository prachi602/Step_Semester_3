package rental.assignment_problems;

import java.time.LocalDate;

public class CodingAssignment extends Assignment {

    public CodingAssignment(
            String title,
            int maxMarks,
            LocalDate dueDate) {

        super(title, maxMarks, dueDate);
    }

    @Override
    public double applyLatePenalty(
            double awardedMarks,
            long lateDays) {

        double penaltyRate = 0.10 * lateDays;

        return Math.max(
                0,
                awardedMarks * (1 - penaltyRate)
        );
    }
}