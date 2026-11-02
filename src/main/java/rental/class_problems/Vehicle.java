package rental.class_problems;

public abstract class Vehicle {

    protected String passNumber;
    protected String owner;

    public Vehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }

    public abstract int calculatePassFee();

    public String getPassNumber() {
        return passNumber;
    }

    public String getVehicleType() {
        return getClass().getSimpleName();
    }
}
