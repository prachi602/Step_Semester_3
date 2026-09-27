package rental.assignment_problems;

public class AppChannel implements NotificationChannel {

    @Override
    public String getName() {
        return "App";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[App → " + student.getName() + "] " + notice.getTitle());
    }
}