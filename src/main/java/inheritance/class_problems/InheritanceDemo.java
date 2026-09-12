package inheritance.class_problems;

public class InheritanceDemo {

    public static String classifyGeneration(
            LibraryMember member) {

        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof StudentMember) {
            return "Student descendant";
        }

        return "General member";
    }

    public static int getTotalBooksBorrowed(
            LibraryMember[] members) {

        int total = 0;

        for (LibraryMember member : members) {
            total += member.getBooksBorrowed();
        }

        return total;
    }

    public static void main(String[] args) {

        LibraryMember general =
                new LibraryMember("STU1", 3);

        StudentMember student =
                new StudentMember("STU2", 3, "CSE");

        HonorsStudentMember honors =
                new HonorsStudentMember(
                        "STU3", 3, "ECE", 2);

        FacultyMember faculty =
                new FacultyMember(
                        "STU4", 5, "Physics");

        general.displayInfo();
        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();

        System.out.println(
                classifyGeneration(honors)
        );

        System.out.println(
                classifyGeneration(faculty)
        );

        // Create the borrowing situation from the example
        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        LibraryMember[] members = {
                student,
                honors,
                faculty
        };

        System.out.println(
                "Total Books Borrowed: "
                        + getTotalBooksBorrowed(members)
        );
    }
}