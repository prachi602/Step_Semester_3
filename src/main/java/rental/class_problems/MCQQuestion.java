package rental.class_problems;

public class MCQQuestion extends Question {

    private String correctOption;

    public MCQQuestion(String questionText, int marks, String correctOption) {
        super(questionText, marks);

        if (correctOption == null || correctOption.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Correct option cannot be blank"
            );
        }

        this.correctOption = correctOption;
    }

    @Override
    public boolean evaluateAnswer(String answer) {
        if (answer == null) {
            return false;
        }

        return correctOption.equalsIgnoreCase(answer.trim());
    }
}