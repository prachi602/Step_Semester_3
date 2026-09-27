package rental.assignment_problems;

public class WhatsAppChannel implements NotificationChannel {

    @Override
    public String getName() {
        return "WhatsApp";
    }

    @Override
    public void send(Student student, Notice notice) {
        System.out.println("[WhatsApp → " + student.getName() + "] " + notice.getTitle());
    }
}