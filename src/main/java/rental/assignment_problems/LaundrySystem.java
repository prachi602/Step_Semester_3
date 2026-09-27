package rental.assignment_problems;

public class LaundrySystem {

    public WashCycle startWash(
            Student student,
            WashingMachine machine,
            WashType washType) {

        if (student == null || machine == null || washType == null) {
            throw new IllegalArgumentException(
                    "Student, machine and wash type are required"
            );
        }

        if (!machine.startWash()) {
            System.out.println(
                    "Machine " + machine.getMachineId()
                            + " is currently busy."
            );
            return null;
        }

        WashCycle cycle =
                new WashCycle(student, machine, washType);

        System.out.printf(
                "%s wash started on %s for %s (%d min). Charge: ₹%.2f%n",
                washType.getName(),
                machine.getMachineId(),
                student.getName(),
                washType.getDurationMinutes(),
                washType.getCharge()
        );

        return cycle;
    }

    public void completeWash(WashCycle cycle) {

        if (cycle == null) {
            System.out.println("Invalid wash cycle.");
            return;
        }

        if (cycle.isCompleted()) {
            System.out.println("Wash cycle is already completed.");
            return;
        }

        cycle.completeCycle();

        System.out.println(
                "Machine "
                        + cycle.getMachine().getMachineId()
                        + " cycle completed."
        );

        System.out.println(
                "Machine "
                        + cycle.getMachine().getMachineId()
                        + " is now free."
        );
    }
}