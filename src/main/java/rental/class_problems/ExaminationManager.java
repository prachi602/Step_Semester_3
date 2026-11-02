package rental.class_problems;

import java.util.ArrayList;
import java.util.List;

public class ExaminationManager {

    private List<Attempt> attempts;

    public ExaminationManager() {
        attempts = new ArrayList<>();
    }

    public boolean addAttempt(Attempt attempt) {
        if (attempt == null) {
            return false;
        }

        for (Attempt existing : attempts) {
            if (existing.getStudent().getStudentId()
                    .equals(attempt.getStudent().getStudentId())
                    && existing.getExamination().getExamId()
                    .equals(attempt.getExamination().getExamId())
                    && existing.getStatus() == Attempt.Status.SUBMITTED) {

                return false;
            }
        }

        attempts.add(attempt);
        return true;
    }

    public boolean hasSubmittedAttempt(
            Student student,
            Examination examination) {

        for (Attempt attempt : attempts) {
            if (attempt.getStudent().getStudentId()
                    .equals(student.getStudentId())
                    && attempt.getExamination().getExamId()
                    .equals(examination.getExamId())
                    && attempt.getStatus() == Attempt.Status.SUBMITTED) {

                return true;
            }
        }

        return false;
    }
}

