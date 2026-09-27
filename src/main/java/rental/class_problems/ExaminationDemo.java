package rental.class_problems;

public class ExaminationDemo {

    public static void main(String[] args) {

        Student student =
                new Student("S101", "Alice");

        Examination exam =
                new Examination("EX101", "Java Fundamentals");

        MCQQuestion question1 =
                new MCQQuestion(
                        "Which keyword is used to inherit a class?",
                        5,
                        "C"
                );

        TrueFalseQuestion question2 =
                new TrueFalseQuestion(
                        "Java supports multiple inheritance using classes.",
                        5,
                        false
                );

        exam.addQuestion(question1);
        exam.addQuestion(question2);

        Attempt attempt =
                new Attempt(student, exam);

        Answer answer1 =
                new Answer(question1, "C");

        Answer answer2 =
                new Answer(question2, "true");

        attempt.addAnswer(answer1);
        attempt.addAnswer(answer2);

        System.out.println(
                "Q1 Result: "
                        + (answer1.isCorrect()
                        ? "Correct " + answer1.getMarksObtained()
                        : "Incorrect 0")
        );

        System.out.println(
                "Q2 Result: "
                        + (answer2.isCorrect()
                        ? "Correct " + answer2.getMarksObtained()
                        : "Incorrect 0")
        );

        System.out.println(
                "Total: "
                        + attempt.calculateTotalMarks()
                        + "/"
                        + exam.getTotalMarks()
        );

        attempt.submit();

        System.out.println(
                "Attempt status: "
                        + attempt.getStatus()
        );
    }
}