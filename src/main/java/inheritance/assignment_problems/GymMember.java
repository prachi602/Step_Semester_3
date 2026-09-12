package inheritance.assignment_problems;

public class GymMember {

    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;
    private static int membersEnrolled = 0;
    private int feesPaid = 0;

    public final String membershipNumber;

    public GymMember(String memberId, int monthlyFee) {

        if (memberId == null ||
                memberId.trim().isEmpty() ||
                memberId.length() < 4) {

            throw new IllegalArgumentException(
                    "Member ID must contain at least 4 characters"
            );
        }

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive"
            );
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }
    public GymMember(int monthlyFee) {

        if (monthlyFee <= 0) {
            throw new IllegalArgumentException(
                    "Monthly fee must be positive"
            );
        }

        this.memberId = null;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;

        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }
    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        // Mode is recorded before delegating.
        payFee(amount);
    }
    public int getFeesPaid() {
        return feesPaid;
    }
    public static boolean isValidReferralCode(String code) {

        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }
    public static String processWeeklyCheckIn(
            GymMember[] members) {

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMember member : members) {

            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMember) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + group + " group | "
                + individual + " individual";
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }
    public void displayInfo() {
        System.out.println(
                "Standard Member | Sessions: "
                        + sessionsAttended
        );
    }
    protected void chargeLateFee(int amount) {
        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount] = amount;
            lateFeeCount++;
        }
    }
    public int[] getLateFeeHistory() {
        int[] history = new int[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            history[i] = lateFeeHistory[i];
        }

        return history;
    }
    public int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }

    public static String signUpBatch(
            String[] memberIds,
            int monthlyFee) {

        int signedUp = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new GymMember(memberId, monthlyFee);
                signedUp++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp
                + " | Rejected: " + rejected;
    }
}
