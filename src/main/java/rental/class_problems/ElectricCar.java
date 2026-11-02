package rental.class_problems;

public class ElectricCar extends Vehicle implements Chargeable {

    public ElectricCar(String passNumber, String owner) {
        super(passNumber, owner);
    }

    @Override
    public int calculatePassFee() {
        return 1000;
    }

    @Override
    public void bookChargingBay() {
        System.out.println(passNumber + " charging bay allotted");
    }
}