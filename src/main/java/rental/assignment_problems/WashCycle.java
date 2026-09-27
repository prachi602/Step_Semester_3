package rental.assignment_problems;

public class WashCycle {

    private Student student;
    private WashingMachine machine;
    private WashType washType;
    private boolean completed;

    public WashCycle(
            Student student,
            WashingMachine machine,
            WashType washType) {

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null"
            );
        }

        if (machine == null) {
            throw new IllegalArgumentException(
                    "Machine cannot be null"
            );
        }

        if (washType == null) {
            throw new IllegalArgumentException(
                    "Wash type cannot be null"
            );
        }

        this.student = student;
        this.machine = machine;
        this.washType = washType;
        this.completed = false;
    }

    public Student getStudent() {
        return student;
    }

    public WashingMachine getMachine() {
        return machine;
    }

    public WashType getWashType() {
        return washType;
    }

    public boolean isCompleted() {
        return completed;
    }

    public double calculateCharge() {
        return washType.getCharge();
    }

    public void completeCycle() {
        if (completed) {
            return;
        }

        completed = true;
        machine.completeWash();
    }
}