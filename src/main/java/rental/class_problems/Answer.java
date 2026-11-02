package rental.class_problems;

public class Answer {

    private Question question;
    private String response;

    public Answer(Question question, String response) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }

        this.question = question;
        this.response = response;
    }

    public Question getQuestion() {
        return question;
    }

    public String getResponse() {
        return response;
    }

    public boolean isCorrect() {
        return question.evaluateAnswer(response);
    }

    public int getMarksObtained() {
        return isCorrect() ? question.getMarks() : 0;
    }
}