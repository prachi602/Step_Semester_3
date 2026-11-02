package rental.class_problems;

import java.util.ArrayList;
import java.util.List;

public class Examination {

    private String examId;
    private String title;
    private List<Question> questions;

    public Examination(String examId, String title) {
        if (examId == null || examId.trim().isEmpty()) {
            throw new IllegalArgumentException("Exam ID cannot be blank");
        }

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Exam title cannot be blank");
        }

        this.examId = examId;
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }

        questions.add(question);
    }

    public String getExamId() {
        return examId;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getTotalMarks() {
        int total = 0;

        for (Question question : questions) {
            total += question.getMarks();
        }

        return total;
    }
}