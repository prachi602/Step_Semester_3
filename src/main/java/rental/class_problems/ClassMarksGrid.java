package rental.class_problems;

import java.util.Scanner;

public class ClassMarksGrid {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        String[] names = new String[n];
        int[][] marks = new int[n][3];

        int[] totals = new int[n];
        int[] subjectTotals = new int[3];

        // Input student details and marks
        for (int i = 0; i < n; i++) {

            System.out.print("Enter student name: ");
            names[i] = sc.next();

            System.out.println("Enter marks in 3 subjects:");

            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextInt();

                totals[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }
        }

        // Display individual totals
        System.out.println("\nStudent Totals:");

        int topperIndex = 0;

        for (int i = 0; i < n; i++) {

            System.out.println(names[i] + " total: " + totals[i]);

            if (totals[i] > totals[topperIndex]) {
                topperIndex = i;
            }
        }

        // Calculate subject-wise averages
        System.out.println("\nSubject Averages:");

        for (int j = 0; j < 3; j++) {

            double average = (double) subjectTotals[j] / n;

            System.out.printf("Subject %d: %.2f%n", j + 1, average);
        }

        // Display topper
        System.out.println("\nClass Topper: "
                + names[topperIndex] + " (" + totals[topperIndex] + ")");

        sc.close();
    }
}