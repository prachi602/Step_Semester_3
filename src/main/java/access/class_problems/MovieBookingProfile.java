package access.class_problems;

public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-argument constructor
    public MovieBookingProfile() {
    }

    // Convenience constructor using this()
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // JavaBean getter
    public String getName() {
        return name;
    }

    // JavaBean setter
    public void setName(String name) {
        this.name = name;
    }

    // JavaBean setter for boolean
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // JavaBean boolean getter uses isConfirmed()
    public boolean isConfirmed() {
        return confirmed;
    }

    // Write-only OTP property
    public void setOtp(String otp) {

        if (otp == null || !otp.matches("\\d{4,6}")) {
            throw new IllegalArgumentException(
                    "OTP must contain 4 to 6 digits"
            );
        }

        this.otp = otp;
    }

    public static void main(String[] args) {

        MovieBookingProfile profile =
                new MovieBookingProfile("Prachi");

        System.out.println("Name: " + profile.getName());

        profile.setConfirmed(true);

        System.out.println(
                "Confirmed: " + profile.isConfirmed()
        );

        profile.setOtp("123456");

        System.out.println("OTP set successfully.");
    }
}