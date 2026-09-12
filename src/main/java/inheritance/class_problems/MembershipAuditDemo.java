package inheritance.class_problems;

public class MembershipAuditDemo {

    public static void main(String[] args) {

        LibraryMember m1 = new LibraryMember(3);

        System.out.println("Member Number: " + m1.memberNumber);
        System.out.println(
                "Members Enrolled: "
                        + LibraryMember.getMembersEnrolled()
        );

        System.out.println(
                "R12A: "
                        + LibraryMember.isValidRenewalCode("R12A")
        );

        System.out.println(
                "R1A: "
                        + LibraryMember.isValidRenewalCode("R1A")
        );

        System.out.println(
                "X12A: "
                        + LibraryMember.isValidRenewalCode("X12A")
        );

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(
                "Books Borrowed: " + m1.getBooksBorrowed()
        );

        LibraryMember[] members = {
                new FacultyMember(5, "Physics"),
                null,
                new LibraryMember(3)
        };

        System.out.println(
                LibraryMember.processNightlyAudit(members)
        );
    }
}