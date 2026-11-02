
package rental.assignment_problems;

import java.util.Scanner;

class Team {
    String teamName;
    int teamSize;

    Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
    }
}

public class HackathonRegistrationDesk {

    static void insertionSort(Team[] teams) {

        for (int i = 1; i < teams.length; i++) {

            Team key = teams[i];
            int j = i - 1;

            while (j >= 0 && teams[j].teamSize > key.teamSize) {
                teams[j + 1] = teams[j];
                j--;
            }

            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        Team[] teams = new Team[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter team name: ");
            String name = sc.nextLine();

            System.out.print("Enter team size: ");
            int size = sc.nextInt();
            sc.nextLine();

            teams[i] = new Team(name, size);
        }

        insertionSort(teams);

        System.out.println("\nTeams after sorting:");

        for (Team team : teams) {
            System.out.println(team.teamName + " - " + team.teamSize);
        }

        sc.close();
    }
}
