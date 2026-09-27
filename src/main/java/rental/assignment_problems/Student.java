package rental.assignment_problems;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentId;
    private String name;
    private String department;
    private List<NotificationChannel> preferredChannels;

    // Constructor used by Assignment Problem 1
    public Student(String studentId, String name) {
        this(studentId, name, "");
    }

    // Constructor for Assignment Problem 5
    public Student(String studentId, String name, String department) {

        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID is required.");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name is required.");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department is required.");
        }

        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.preferredChannels = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addPreferredChannel(NotificationChannel channel) {
        if (channel == null) {
            throw new IllegalArgumentException("Notification channel cannot be null.");
        }

        preferredChannels.add(channel);
    }

    public List<NotificationChannel> getPreferredChannels() {
        return new ArrayList<>(preferredChannels);
    }
}