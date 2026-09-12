package access.class_problems;

public class NightlySettlementProcessor {

    public static String processNightlySettlement(
            BookingReceipt[] receipts) {

        int processed = 0;
        int nullCount = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        for (BookingReceipt receipt : receipts) {

            // Handle null entries safely
            if (receipt == null) {
                nullCount++;
                continue;
            }

            processed++;

            // Check whether the receipt is a group booking
            if (receipt instanceof GroupBookingReceipt) {
                groupCount++;
            } else {
                individualCount++;
            }
        }

        return processed + " processed | "
                + nullCount + " null skipped | "
                + groupCount + " group | "
                + individualCount + " individual";
    }

    public static void main(String[] args) {

        BookingReceipt[] receipts = {
                new GroupBookingReceipt(
                        "CH-2002",
                        new String[]{"B1", "B2"},
                        2
                ),

                null,

                new BookingReceipt(
                        "CH-3003",
                        new String[]{"C1"}
                )
        };

        System.out.println(
                processNightlySettlement(receipts)
        );
    }
}