package rental.assignment_problems;

import java.time.LocalDate;

public class Submission {

    public enum Status {
        SUBMITTED,
        GRADED
    }

    private Student student;
    private Assignment assignment;
    private LocalDate submissionDate;
    private Status status;
    private double finalMarks;

    public Submission(
            Student student,
            Assignment assignment,
            LocalDate submissionDate) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        if (assignment == null) {
            throw new IllegalArgumentException(
                    "Assignment cannot be null"
            );
        }

        if (submissionDate == null) {
            throw new IllegalArgumentException(
                    "Submission date cannot be null"
            );
        }

        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = Status.SUBMITTED;
        this.finalMarks = 0;
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public Status getStatus() {
        return status;
    }

    public double getFinalMarks() {
        return finalMarks;
    }

    public boolean grade(double awardedMarks) {

        if (status == Status.GRADED) {
            return false;
        }

        if (awardedMarks < 0
                || awardedMarks > assignment.getMaxMarks()) {
            return false;
        }

        long lateDays =
                assignment.getLateDays(submissionDate);

        finalMarks =
                assignment.applyLatePenalty(
                        awardedMarks,
                        lateDays
                );

        status = Status.GRADED;

        return true;
    }
}
