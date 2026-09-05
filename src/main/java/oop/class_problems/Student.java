package oop.class_problems;

public class Student {

    // Instance fields
    String name;
    double attendance;

    // Static field
    static String collegeName = "SRM Institute of Science and Technology";

    // Static counter
    static int studentCount = 0;

    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        Student student1 = new Student("Ravi", 85.5);
        Student student2 = new Student("Anitha", 92.0);

        Student.printCollegeInfo();
    }
}
