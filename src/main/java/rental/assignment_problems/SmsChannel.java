package rental.assignment_problems;

public class SmsChannel implements NotificationChannel {

    @Override
    public String getName() {
        return "SMS";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[SMS → " + student.getName() + "] " + notice.getTitle());
    }
}
