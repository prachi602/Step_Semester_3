package rental.class_problems;

import java.util.Objects;

public class Student {

    private String rollNumber;
    private String name;

    public Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    // Compare students using roll number only
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;

        return rollNumber.equals(other.rollNumber);
    }

    // Generate hash code using roll number
    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }
}