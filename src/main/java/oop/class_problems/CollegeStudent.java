package oop.class_problems;

public class CollegeStudent {

    private static String collegeName;
    private static String academicYear;

    private String studentName;

    // Static block runs only once
    static {
        collegeName = "SRM University";
        academicYear = "2026-27";

        System.out.println("College info loaded");
    }

    public CollegeStudent(String studentName) {
        this.studentName = studentName;

        System.out.println(
                "Student record created: " + studentName
        );
    }

    public static void main(String[] args) {

        String[] names = {
                "Ravi",
                "Meera",
                "Karthik",
                "Divya",
                "Anitha"
        };

        CollegeStudent[] students =
                new CollegeStudent[names.length];

        for (int i = 0; i < students.length; i++) {
            students[i] =
                    new CollegeStudent(names[i]);
        }
    }
}