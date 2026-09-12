package inheritance.assignment_problems;

public class MonthlyAttendanceAnnouncer {

    public static String batchPrint(GymMember[] members) {

        StringBuilder announcement = new StringBuilder();

        for (GymMember member : members) {

            member.displayInfo();

            if (member instanceof PremiumMember) {

                PremiumMember premium =
                        (PremiumMember) member;

                announcement
                        .append("Premium | Trainer: ")
                        .append(premium.getTrainerName())
                        .append(" | Sessions: ")
                        .append(premium.getSessionsAttended())
                        .append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("] | ");

            } else {

                announcement
                        .append("Standard | Sessions: ")
                        .append(member.getSessionsAttended())
                        .append(" | ");
            }
        }

        return announcement.toString();
    }

    public static void main(String[] args) {

        GymMember standard =
                new GymMember("MEM6", 1000);

        PremiumMember premium =
                new PremiumMember(
                        "MEM7",
                        2000,
                        "Coach Riya"
                );

        GymMember[] members = {
                standard,
                premium
        };

        System.out.println(
                batchPrint(members)
        );
    }
}
