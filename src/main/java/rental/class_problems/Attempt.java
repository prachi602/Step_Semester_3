package rental.class_problems;

import java.util.ArrayList;
import java.util.List;

public class Attempt {

    public enum Status {
        IN_PROGRESS,
        SUBMITTED
    }

    private Student student;
    private Examination examination;
    private List<Answer> answers;
    private Status status;

    public Attempt(Student student, Examination examination) {

        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        if (examination == null) {
            throw new IllegalArgumentException(
                    "Examination cannot be null"
            );
        }

        this.student = student;
        this.examination = examination;
        this.answers = new ArrayList<>();
        this.status = Status.IN_PROGRESS;
    }

    public void addAnswer(Answer answer) {

        if (status == Status.SUBMITTED) {
            throw new IllegalStateException(
                    "Submitted answers cannot be modified"
            );
        }

        if (answer == null) {
            throw new IllegalArgumentException("Answer cannot be null");
        }

        answers.add(answer);
    }

    public void submit() {
        if (status == Status.SUBMITTED) {
            throw new IllegalStateException(
                    "Attempt has already been submitted"
            );
        }

        status = Status.SUBMITTED;
    }

    public Student getStudent() {
        return student;
    }

    public Examination getExamination() {
        return examination;
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public Status getStatus() {
        return status;
    }

    public int calculateTotalMarks() {

        int total = 0;

        for (Answer answer : answers) {
            total += answer.getMarksObtained();
        }

        return total;
    }
}