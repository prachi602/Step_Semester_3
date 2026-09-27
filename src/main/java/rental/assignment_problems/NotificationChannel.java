package rental.assignment_problems;

public interface NotificationChannel {

    String getName();

    void send(Student student, Notice notice);
}