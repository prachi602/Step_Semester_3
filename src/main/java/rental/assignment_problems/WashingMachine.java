package rental.assignment_problems;

public class WashingMachine {

    private String machineId;
    private boolean busy;

    public WashingMachine(String machineId) {
        if (machineId == null || machineId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Machine ID cannot be blank"
            );
        }

        this.machineId = machineId;
        this.busy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isFree() {
        return !busy;
    }

    public boolean startWash() {
        if (busy) {
            return false;
        }

        busy = true;
        return true;
    }

    public void completeWash() {
        busy = false;
    }
}