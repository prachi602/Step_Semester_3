package inheritance.assignment_problems;

public class WeeklySettlementDemo {

    public static void main(String[] args) {

        GymMember m1 =
                new GymMember(1000);

        System.out.println(
                "Membership Number: "
                        + m1.membershipNumber
        );

        System.out.println(
                "Members Enrolled: "
                        + GymMember.getMembersEnrolled()
        );

        System.out.println(
                "G45B: "
                        + GymMember.isValidReferralCode("G45B")
        );

        System.out.println(
                "G4B: "
                        + GymMember.isValidReferralCode("G4B")
        );

        System.out.println(
                "X45B: "
                        + GymMember.isValidReferralCode("X45B")
        );

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(
                "Fees Paid: "
                        + m1.getFeesPaid()
        );

        GymMember[] members = {
                new GroupClassMember(1500, "Zumba"),
                null,
                new GymMember(1000)
        };

        System.out.println(
                GymMember.processWeeklyCheckIn(members)
        );
    }
}