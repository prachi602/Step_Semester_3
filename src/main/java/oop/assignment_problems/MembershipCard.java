package oop.assignment_problems;

public class MembershipCard {

    // Static fields shared by all membership cards
    static String libraryName;
    static String validUntil;

    // Instance field
    private String studentName;

    // Static block runs only once when the class is loaded
    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";

        System.out.println("Library info loaded");
    }

    // Constructor
    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public void printConfirmation() {
        System.out.println(
                "Membership card issued: " + studentName
        );
    }

    public static void main(String[] args) {

        String[] names = {
                "Ananya",
                "Rohan",
                "Priya",
                "Arjun",
                "Sneha"
        };

        // Create cards for every student
        for (String name : names) {

            MembershipCard card =
                    new MembershipCard(name);

            card.printConfirmation();
        }
    }
}
