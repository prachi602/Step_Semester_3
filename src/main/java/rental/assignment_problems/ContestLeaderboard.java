
package rental.assignment_problems;

import java.util.Scanner;

class Contestant {
    String name;
    int marks;

    Contestant(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class ContestLeaderboard {

    static void countingSort(Contestant[] contestants) {

        int[] count = new int[101];

        // Step 1: Count frequency of each mark
        for (Contestant c : contestants) {
            count[c.marks]++;
        }

        // Step 2: Convert frequency into cumulative count
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place contestants in sorted order
        // Traverse right to left to maintain stability
        Contestant[] output = new Contestant[contestants.length];

        for (int i = contestants.length - 1; i >= 0; i--) {

            int marks = contestants[i].marks;

            output[count[marks] - 1] = contestants[i];

            count[marks]--;
        }

        // Step 4: Copy sorted result back
        for (int i = 0; i < contestants.length; i++) {
            contestants[i] = output[i];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of contestants: ");
        int n = sc.nextInt();
        sc.nextLine();

        Contestant[] contestants = new Contestant[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter contestant name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks (0-100): ");
            int marks = sc.nextInt();
            sc.nextLine();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Enter marks between 0 and 100.");
                i--;
                continue;
            }

            contestants[i] = new Contestant(name, marks);
        }

        countingSort(contestants);

        System.out.println("\nContest Leaderboard:");

        for (Contestant c : contestants) {
            System.out.println(c.name + " - " + c.marks);
        }

        sc.close();
    }
}
