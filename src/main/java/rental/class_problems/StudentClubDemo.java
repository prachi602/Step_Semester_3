package rental.class_problems;

import java.util.*;

public class StudentClubDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Set<Student> members = new HashSet<>();

        List<String> addResults = new ArrayList<>();
        List<String> containsResults = new ArrayList<>();

        while (sc.hasNextLine()) {

            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equalsIgnoreCase("ADD")) {

                String rollNumber = parts[1];
                String name = parts[2];

                Student student = new Student(rollNumber, name);

                if (members.add(student)) {
                    addResults.add(rollNumber + " added");
                } else {
                    addResults.add(rollNumber + " duplicate rejected");
                }

            } else if (parts[0].equalsIgnoreCase("CONTAINS")) {

                String rollNumber = parts[1];
                String name = parts[2];

                Student student = new Student(rollNumber, name);

                containsResults.add(
                        "Contains " + rollNumber + ": " + members.contains(student)
                );
            }
        }

        // Display addition results
        for (String result : addResults) {
            System.out.println(result);
        }

        // Display total members
        System.out.println("Member count: " + members.size());

        // Display contains results
        for (String result : containsResults) {
            System.out.println(result);
        }

        sc.close();
    }
}