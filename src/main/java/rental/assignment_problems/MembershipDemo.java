package rental.assignment_problems;

public class MembershipDemo {

    public static void main(String[] args) {

        Member asha =
                new Member("M101", "Asha");

        Member ravi =
                new Member("M102", "Ravi");

        MembershipPlan quarterlyPlan =
                new QuarterlyPlan();

        MembershipPlan monthlyPlan =
                new MonthlyPlan();

        Membership ashaMembership =
                new Membership(
                        asha,
                        quarterlyPlan
                );

        Membership raviMembership =
                new Membership(
                        ravi,
                        monthlyPlan
                );

        // Asha buys Quarterly membership
        System.out.printf(
                "Quarterly membership created for %s.%n",
                asha.getName()
        );

        System.out.printf(
                "Fee: ₹%.2f%n",
                ashaMembership.getFee()
        );

        System.out.println(
                "Status: "
                        + formatStatus(
                        ashaMembership.getStatus())
        );

        // Ravi buys Monthly membership
        System.out.printf(
                "Monthly membership created for %s.%n",
                ravi.getName()
        );

        System.out.printf(
                "Fee: ₹%.2f%n",
                raviMembership.getFee()
        );

        System.out.println(
                "Status: "
                        + formatStatus(
                        raviMembership.getStatus())
        );

        // Asha checks in
        if (ashaMembership.checkIn()) {
            System.out.println(
                    "Asha checked in successfully."
            );
        }

        // Asha freezes membership
        if (ashaMembership.freeze()) {
            System.out.println(
                    "Asha's membership frozen."
            );
        }

        System.out.println(
                "Status: "
                        + formatStatus(
                        ashaMembership.getStatus())
        );

        // Asha attempts to check in while frozen
        if (!ashaMembership.checkIn()) {
            System.out.println(
                    "Check-in denied: Asha's membership is Frozen."
            );
        }

        // Ravi's membership expires
        if (raviMembership.expire()) {
            System.out.println(
                    "Ravi's membership expired."
            );
        }

        System.out.println(
                "Status: "
                        + formatStatus(
                        raviMembership.getStatus())
        );

        // Ravi attempts to freeze expired membership
        if (!raviMembership.freeze()) {
            System.out.println(
                    "Cannot freeze an Expired membership."
            );
        }
    }

    private static String formatStatus(
            Membership.Status status) {

        String value = status.name().toLowerCase();

        return Character.toUpperCase(value.charAt(0))
                + value.substring(1);
    }
}