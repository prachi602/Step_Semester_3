package rental.class_problems;

public class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(String questionText, int marks, boolean correctAnswer) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluateAnswer(String answer) {
        if (answer == null) {
            return false;
        }

        return Boolean.parseBoolean(answer.trim()) == correctAnswer;
    }
}