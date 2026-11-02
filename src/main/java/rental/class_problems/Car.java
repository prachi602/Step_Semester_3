package rental.class_problems;

public class Car extends Vehicle {

    public Car(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int calculatePassFee() {
        return 1000;
    }
}