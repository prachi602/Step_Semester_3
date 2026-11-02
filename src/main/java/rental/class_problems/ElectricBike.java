package rental.class_problems;

public class ElectricBike extends Vehicle implements Chargeable {

    public ElectricBike(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int calculatePassFee() {
        return 300;
    }

    @Override
    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}