package rental.class_problems;

public class ShortAnswerQuestion extends Question {

    private String correctAnswer;

    public ShortAnswerQuestion(
            String questionText,
            int marks,
            String correctAnswer) {

        super(questionText, marks);

        if (correctAnswer == null || correctAnswer.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Correct answer cannot be blank"
            );
        }

        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluateAnswer(String answer) {
        if (answer == null) {
            return false;
        }

        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}
