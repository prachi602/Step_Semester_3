package rental.assignment_problems;

import java.util.Scanner;

public class PriorityTokenInsertion {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Singly Linked List class
    static class LinkedList {

        Node head;

        // Insert at beginning
        void addFirst(int token) {

            Node newNode = new Node(token);

            newNode.next = head;
            head = newNode;
        }

        // Insert at end
        void addLast(int token) {

            Node newNode = new Node(token);

            if (head == null) {
                head = newNode;
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        // Insert at a given 0-based index
        void insertAt(int index, int token) {

            if (index < 0) {
                System.out.println("Invalid index");
                return;
            }

            if (index == 0) {
                addFirst(token);
                return;
            }

            Node temp = head;

            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid index");
                return;
            }

            Node newNode = new Node(token);

            newNode.next = temp.next;
            temp.next = newNode;
        }

        // Display list
        void display() {

            Node temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.print("Enter number of starting tokens: ");
        int n = sc.nextInt();

        System.out.println("Enter starting tokens:");

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        System.out.print("Enter number of operations: ");
        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Insert At");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter token: ");
                    list.addFirst(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter token: ");
                    list.addLast(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter index and token: ");
                    int index = sc.nextInt();
                    int token = sc.nextInt();

                    list.insertAt(index, token);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        System.out.println("Final Token List:");
        list.display();

        sc.close();
    }
}