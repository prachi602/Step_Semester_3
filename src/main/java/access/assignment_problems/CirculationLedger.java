package access.assignment_problems;

public class CirculationLedger {

    private static final String BRANCH_CODE;

    // Static block - runs once when the class is loaded
    static {
        BRANCH_CODE = "CHN01";
    }

    public static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts == null) {
            return "0 processed | 0 null skipped | "
                    + "0 reference-only | 0 regular";
        }

        // Single pass through the array
        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }

    public static void main(String[] args) {

        LoanReceipt regularReceipt =
                new LoanReceipt(
                        "M001",
                        new String[]{"B101", "B102"}
                );

        ReferenceOnlyLoanReceipt referenceReceipt =
                new ReferenceOnlyLoanReceipt(
                        "M002",
                        new String[]{"B201"},
                        "ROOM-12"
                );

        LoanReceipt[] receipts = {
                regularReceipt,
                null,
                referenceReceipt
        };

        System.out.println(
                processNightlyCirculation(receipts)
        );
    }
}