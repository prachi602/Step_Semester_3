package rental.assignment_problems;

public class EmailChannel implements NotificationChannel {

    @Override
    public String getName() {
        return "Email";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[Email → " + student.getName() + "] " + notice.getTitle());
    }
}