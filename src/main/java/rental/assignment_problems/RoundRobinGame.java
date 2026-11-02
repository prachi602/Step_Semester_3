package rental.assignment_problems;

import java.util.Scanner;

public class RoundRobinGame {

    // Node class
    static class Node {
        String name;
        Node next;

        Node(String name) {
            this.name = name;
            this.next = null;
        }
    }

    // Circular Linked List class
    static class CircularLinkedList {

        Node tail;

        // Add player at the end
        void addLast(String name) {

            Node newNode = new Node(name);

            // First node
            if (tail == null) {
                tail = newNode;
                tail.next = tail;
                return;
            }

            // Insert new node after tail
            newNode.next = tail.next;
            tail.next = newNode;

            // Update tail
            tail = newNode;
        }

        // Print players for given number of turns
        void printTurns(int turns) {

            if (tail == null) {
                System.out.println("No players available");
                return;
            }

            Node current = tail.next; // Head

            System.out.print("Player Turns: ");

            for (int i = 0; i < turns; i++) {

                System.out.print(current.name);

                if (i < turns - 1) {
                    System.out.print(" ");
                }

                current = current.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CircularLinkedList players = new CircularLinkedList();

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        System.out.println("Enter player names:");

        for (int i = 0; i < n; i++) {
            players.addLast(sc.next());
        }

        System.out.print("Enter number of turns: ");
        int turns = sc.nextInt();

        players.printTurns(turns);

        sc.close();
    }
}