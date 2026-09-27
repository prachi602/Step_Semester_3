package rental.assignment_problems;

import java.time.LocalDate;

public class AssignmentDemo {

    public static void main(String[] args) {

        SubmissionPortal portal =
                new SubmissionPortal();

        Student asha =
                new Student("S101", "Asha");

        Student ravi =
                new Student("S102", "Ravi");

        CodingAssignment codingAssignment =
                new CodingAssignment(
                        "Linked List Lab",
                        50,
                        LocalDate.of(2027, 3, 10)
                );

        WrittenAssignment writtenAssignment =
                new WrittenAssignment(
                        "Design Essay",
                        50,
                        LocalDate.of(2027, 3, 12)
                );

        // Asha submits Coding assignment on time
        Submission ashaSubmission =
                portal.submit(
                        asha,
                        codingAssignment,
                        LocalDate.of(2027, 3, 10),
                        null
                );

        // Ravi submits Written assignment 2 days late
        Submission raviSubmission =
                portal.submit(
                        ravi,
                        writtenAssignment,
                        LocalDate.of(2027, 3, 14),
                        null
                );

        // Faculty grades Asha: 45/50
        portal.gradeSubmission(
                ashaSubmission,
                45
        );

        // Faculty grades Ravi: 40/50
        // 2 days late → 40% penalty → 24/50
        portal.gradeSubmission(
                raviSubmission,
                40
        );

        // Asha attempts to resubmit after grading
        portal.submit(
                asha,
                codingAssignment,
                LocalDate.of(2027, 3, 11),
                ashaSubmission
        );
    }
}