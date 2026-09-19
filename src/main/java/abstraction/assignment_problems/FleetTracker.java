package abstraction.assignment_problems;

public class FleetTracker {

    public static String getLocationIfTrackable(Object o) {

        if (o instanceof Trackable) {
            Trackable trackable = (Trackable) o;
            return trackable.getLocation();
        }

        return "Tracking not available";
    }

    public static void main(String[] args) {

        DeliveryDrone d = new DeliveryDrone("DR-1");
        ScoutDrone s = new ScoutDrone("SC-1");
        GroundRobot g = new GroundRobot("GR-1");

        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(g));
    }
}