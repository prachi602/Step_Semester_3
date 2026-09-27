package rental.assignment_problems;

import java.time.LocalDate;

public class SubmissionPortal {

    public Submission submit(
            Student student,
            Assignment assignment,
            LocalDate submissionDate,
            Submission existingSubmission) {

        if (existingSubmission != null
                && existingSubmission.getStatus()
                == Submission.Status.GRADED) {

            System.out.println(
                    "Cannot resubmit: '"
                            + assignment.getTitle()
                            + "' has already been graded."
            );

            return null;
        }

        Submission submission =
                new Submission(
                        student,
                        assignment,
                        submissionDate
                );

        long lateDays =
                assignment.getLateDays(submissionDate);

        if (lateDays == 0) {
            System.out.println(
                    student.getName()
                            + "'s submission for '"
                            + assignment.getTitle()
                            + "' received (on time)."
            );
        } else {
            System.out.println(
                    student.getName()
                            + "'s submission for '"
                            + assignment.getTitle()
                            + "' received ("
                            + lateDays
                            + " days late)."
            );
        }

        System.out.println(
                "Status: " + submission.getStatus()
        );

        return submission;
    }

    public boolean gradeSubmission(
            Submission submission,
            double awardedMarks) {

        if (submission == null) {
            return false;
        }

        boolean graded =
                submission.grade(awardedMarks);

        if (graded) {
            System.out.println(
                    submission.getStudent().getName()
                            + " graded: "
                            + formatMarks(
                            submission.getFinalMarks())
                            + "/"
                            + submission.getAssignment()
                            .getMaxMarks()
            );

            System.out.println(
                    "Status: " + submission.getStatus()
            );
        }

        return graded;
    }

    private String formatMarks(double marks) {
        if (marks == Math.floor(marks)) {
            return String.valueOf((int) marks);
        }

        return String.format("%.2f", marks);
    }
}