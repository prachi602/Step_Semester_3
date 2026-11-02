package rental.class_problems;

public abstract class Question {

    private String questionText;
    private int marks;

    public Question(String questionText, int marks) {
        if (questionText == null || questionText.trim().isEmpty()) {
            throw new IllegalArgumentException("Question cannot be blank");
        }

        if (marks <= 0) {
            throw new IllegalArgumentException("Marks must be positive");
        }

        this.questionText = questionText;
        this.marks = marks;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getMarks() {
        return marks;
    }

    public abstract boolean evaluateAnswer(String answer);
}