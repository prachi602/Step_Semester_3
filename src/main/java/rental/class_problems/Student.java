package rental.class_problems;

public class Student {

    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be blank");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank");
        }

        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}