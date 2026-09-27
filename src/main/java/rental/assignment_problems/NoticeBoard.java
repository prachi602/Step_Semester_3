package rental.assignment_problems;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoard {

    private List<Student> students;

    public NoticeBoard() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }

        students.add(student);
    }

    public void postNotice(Notice notice) {
        if (notice == null) {
            throw new IllegalArgumentException("Notice cannot be null.");
        }

        System.out.println("Notice posted: " + notice.getTitle());

        for (Student student : students) {

            if (notice.targetsDepartment(student.getDepartment())) {

                for (NotificationChannel channel : student.getPreferredChannels()) {
                    channel.send(student, notice);
                }
            }
        }
    }
}