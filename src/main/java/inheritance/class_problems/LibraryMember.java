package inheritance.class_problems;

public class LibraryMember {

    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    private static int membersEnrolled = 0;
    public final String memberNumber;

    public LibraryMember(int borrowLimit) {
        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.memberId = null;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;

        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }
    public LibraryMember(String memberId, int borrowLimit) {

        if (memberId == null ||
                memberId.trim().isEmpty() ||
                memberId.length() < 4) {

            throw new IllegalArgumentException(
                    "Member ID must contain at least 4 characters"
            );
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException(
                    "Borrow limit must be positive"
            );
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.booksBorrowed = 0;
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public void borrowBook() {

        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }
    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
    private String lastBorrowedGenre;

    public void borrowBook(String genre) {
        lastBorrowedGenre = genre;
        borrowBook();
    }
    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static String enrollBatch(
            String[] memberIds,
            int borrowLimit) {

        int enrolled = 0;
        int rejected = 0;

        for (String memberId : memberIds) {

            try {
                new LibraryMember(memberId, borrowLimit);
                enrolled++;

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled
                + " | Rejected: " + rejected;
    }
    public static String processNightlyAudit(LibraryMember[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMember member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof FacultyMember) {
                faculty++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + faculty + " faculty | "
                + regular + " regular";
    }
    public void displayInfo() {
        System.out.println(
                "General Member | Books Borrowed: "
                        + booksBorrowed
        );
    }
    protected void chargeFine(int amount) {

        if (fineCount < fineHistory.length) {
            fineHistory[fineCount] = amount;
            fineCount++;
        }
    }

    public int[] getFineHistory() {

        int[] history = new int[fineCount];

        for (int i = 0; i < fineCount; i++) {
            history[i] = fineHistory[i];
        }

        return history;
    }

    public int getTotalFine() {

        int total = 0;

        for (int i = 0; i < fineCount; i++) {
            total += fineHistory[i];
        }

        return total;
    }

    public static void main(String[] args) {

        LibraryMember member =
                new LibraryMember("STU1", 3);

        member.borrowBook();
        member.borrowBook();

        System.out.println(
                "Books Borrowed: "
                        + member.getBooksBorrowed()
        );

        String[] ids = {
                "STU1",
                "LB1",
                "STU2",
                " ",
                "STU3"
        };

        System.out.println(
                enrollBatch(ids, 3)
        );
    }
}