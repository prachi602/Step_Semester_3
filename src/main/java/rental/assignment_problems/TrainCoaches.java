package rental.assignment_problems;

import java.util.Scanner;

public class TrainCoaches {

    // Node class
    static class Node {
        String name;
        Node next;
        Node prev;

        Node(String name) {
            this.name = name;
            this.next = null;
            this.prev = null;
        }
    }

    // Doubly Linked List class
    static class DoublyLinkedList {

        Node head;
        Node tail;

        // Add coach at the end
        void addLast(String name) {

            Node newNode = new Node(name);

            if (head == null) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
        }

        // Remove coach by name
        void remove(String name) {

            Node current = head;

            // Search for the coach
            while (current != null &&
                    !current.name.equals(name)) {

                current = current.next;
            }

            if (current == null) {
                System.out.println("Coach not found");
                return;
            }

            // If removing the head
            if (current == head) {
                head = current.next;
            } else {
                current.prev.next = current.next;
            }

            // If removing the tail
            if (current == tail) {
                tail = current.prev;
            } else {
                current.next.prev = current.prev;
            }
        }

        // Print from head to tail
        void printForward() {

            Node temp = head;

            System.out.print("Forward: ");

            while (temp != null) {

                System.out.print(temp.name);

                if (temp.next != null) {
                    System.out.print(" <-> ");
                }

                temp = temp.next;
            }

            System.out.println();
        }

        // Print from tail to head
        void printBackward() {

            Node temp = tail;

            System.out.print("Backward: ");

            while (temp != null) {

                System.out.print(temp.name);

                if (temp.prev != null) {
                    System.out.print(" <-> ");
                }

                temp = temp.prev;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DoublyLinkedList train = new DoublyLinkedList();

        System.out.print("Enter number of coaches: ");
        int n = sc.nextInt();

        System.out.println("Enter coach names:");

        for (int i = 0; i < n; i++) {
            train.addLast(sc.next());
        }

        System.out.print("Enter coach to remove: ");
        String name = sc.next();

        train.remove(name);

        train.printForward();
        train.printBackward();

        sc.close();
    }
}