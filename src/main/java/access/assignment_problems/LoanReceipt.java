package access.assignment_problems;

public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {

        if (memberId == null || bookIds == null) {
            throw new IllegalArgumentException(
                    "Member ID and book IDs cannot be null"
            );
        }

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = bookIds.clone();
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {

        // Defensive copy
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {

        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException(
                    "Invalid book ID index"
            );
        }

        String[] correctedBookIds = bookIds.clone();

        correctedBookIds[index] = newId;

        // Return a new object
        return new LoanReceipt(memberId, correctedBookIds);
    }

    public static void main(String[] args) {

        String[] books = {"B101", "B102"};

        LoanReceipt receipt =
                new LoanReceipt("M001", books);

        // Defensive-copy test
        books[0] = "CHANGED";

        System.out.println(
                "Original first book: "
                        + receipt.getBookIds()[0]
        );

        // Wither method test
        LoanReceipt corrected =
                receipt.withCorrectedBookId(1, "B999");

        System.out.println(
                "Original second book: "
                        + receipt.getBookIds()[1]
        );

        System.out.println(
                "Corrected second book: "
                        + corrected.getBookIds()[1]
        );
    }
}