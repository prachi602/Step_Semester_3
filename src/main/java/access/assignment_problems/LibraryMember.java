package access.assignment_problems;

public class LibraryMember {

    private String membershipPin;

    String branchCode;

    protected double finesOwed;

    public String displayName;

    public LibraryMember(
            String membershipPin,
            String branchCode,
            double finesOwed,
            String displayName) {

        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static void main(String[] args) {

        LibraryMember member =
                new LibraryMember(
                        "1234",
                        "CHN01",
                        50.0,
                        "Prachi"
                );

        System.out.println(
                "Display Name: " + member.displayName
        );

        System.out.println(
                "Branch Code: " + member.branchCode
        );

        System.out.println(
                "Fines Owed: " + member.finesOwed
        );
    }
}