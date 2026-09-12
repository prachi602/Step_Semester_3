package inheritance.assignment_problems;

public class GymFeeDemo {

    public static void main(String[] args) {

        PremiumMember p =
                new PremiumMember(
                        "MEM5",
                        2000,
                        "Coach Riya"
                );

        p.chargeLateFee(200);

        System.out.println(
                "Total Late Fees: "
                        + p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
                "Recorded Fee: "
                        + p.getLateFeeHistory()[0]
        );
    }
}