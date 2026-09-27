package rental.assignment_problems;

public class LaundryDemo {

    public static void main(String[] args) {

        LaundrySystem system = new LaundrySystem();

        Student asha = new Student("S101", "Asha");
        Student ravi = new Student("S102", "Ravi");
        Student neha = new Student("S103", "Neha");

        WashingMachine machine1 =
                new WashingMachine("M1");

        WashingMachine machine2 =
                new WashingMachine("M2");

        WashType quickWash =
                new QuickWash();

        WashType heavyWash =
                new HeavyWash();

        WashType normalWash =
                new NormalWash();

        // Asha starts Quick wash on M1
        WashCycle ashaCycle =
                system.startWash(
                        asha,
                        machine1,
                        quickWash
                );

        // Ravi attempts Heavy wash on busy M1
        system.startWash(
                ravi,
                machine1,
                heavyWash
        );

        // Ravi starts Heavy wash on M2
        WashCycle raviCycle =
                system.startWash(
                        ravi,
                        machine2,
                        heavyWash
                );

        // M1 completes
        system.completeWash(ashaCycle);

        // Neha starts Normal wash on M1
        system.startWash(
                neha,
                machine1,
                normalWash
        );
    }
}