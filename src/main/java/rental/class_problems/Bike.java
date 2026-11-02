package rental.class_problems;

public class Bike extends Vehicle {

    public Bike(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int calculatePassFee() {
        return 300;
    }
}