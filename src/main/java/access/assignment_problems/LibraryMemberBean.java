package access.assignment_problems;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMemberBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    // Public no-argument constructor
    public LibraryMemberBean() {
    }

    // Membership ID - write-once property
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (membershipId == null) {
            membershipId = id;
        }
    }

    // Name - normal JavaBean property
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Premium status - boolean JavaBean property
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    // Security answer - write-only property
    public void setSecurityAnswer(String answer) {

        if (answer == null) {
            securityAnswer = null;
            return;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash =
                    digest.digest(answer.getBytes(StandardCharsets.UTF_8));

            StringBuilder result = new StringBuilder();

            for (byte b : hash) {
                result.append(String.format("%02x", b));
            }

            securityAnswer = result.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 not available", e);
        }
    }

    public static void main(String[] args) {

        LibraryMemberBean member = new LibraryMemberBean();

        // First value is accepted
        member.setMembershipId("LIB001");

        // Second value should be ignored
        member.setMembershipId("LIB999");

        member.setName("Prachi");
        member.setPremiumMember(true);

        // No getter exists for securityAnswer
        member.setSecurityAnswer("blue");

        System.out.println("Membership ID: "
                + member.getMembershipId());

        System.out.println("Name: "
                + member.getName());

        System.out.println("Premium Member: "
                + member.isPremiumMember());

        System.out.println("Security Answer: write-only");
    }
}