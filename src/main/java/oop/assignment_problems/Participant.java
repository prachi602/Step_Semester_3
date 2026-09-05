package oop.assignment_problems;

public class Participant {

    private String name;
    private String teamName;
    private boolean registered;

    // Constructor for participants who already have a team
    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // Constructor for solo participants
    public Participant(String name) {
        this(name, "Unassigned");
    }

    public void printStatus() {
        System.out.println(
                name + " | " + teamName
                        + " | Registered: " + registered
        );
    }

    public static void main(String[] args) {

        String[] names = {
                "Ravi",
                "Meera",
                "Karthik",
                "Divya"
        };

        String[] teamNames = {
                "ByteBusters",
                "",
                "CodeCrafters",
                ""
        };

        // Process every participant in one pass
        for (int i = 0; i < names.length; i++) {

            Participant participant;

            if (teamNames[i].isEmpty()) {
                participant = new Participant(names[i]);
            } else {
                participant =
                        new Participant(names[i], teamNames[i]);
            }

            participant.printStatus();
        }
    }
}