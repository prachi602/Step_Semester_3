package inheritance.class_problems;

public class WeeklyCirculationReport {

    public static String batchPrint(
            LibraryMember[] members) {

        StringBuilder report = new StringBuilder();

        for (LibraryMember member : members) {

            // Polymorphic call
            member.displayInfo();

            if (member instanceof StudentMember) {

                StudentMember student =
                        (StudentMember) member;

                report.append("Student | Course: ")
                        .append(student.getCourse())
                        .append(" | Books: ")
                        .append(student.getBooksBorrowed())
                        .append(" [Course via downcast: ")
                        .append(student.getCourse())
                        .append("] | ");

            } else {

                report.append("General | Books: ")
                        .append(member.getBooksBorrowed())
                        .append(" | ");
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("LB05", 3);

        StudentMember student =
                new StudentMember("STU6", 3, "ECE");

        LibraryMember[] members = {
                general,
                student
        };

        System.out.println(
                batchPrint(members)
        );
    }
}