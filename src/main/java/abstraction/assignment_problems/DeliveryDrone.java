package abstraction.assignment_problems;

public class DeliveryDrone extends Drone implements Trackable {

    private String id;

    public DeliveryDrone(String id) {
        super();
        this.id = id;
    }

    @Override
    public String fly() {
        return "Delivery drone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}
