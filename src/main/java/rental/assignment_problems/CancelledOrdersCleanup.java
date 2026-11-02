package rental.assignment_problems;

import java.util.Scanner;

public class CancelledOrdersCleanup {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Remove all occurrences of a given code
    static Node removeAll(Node head, int code) {

        // Remove matching nodes from the beginning
        while (head != null && head.data == code) {
            head = head.next;
        }

        // Remove matching nodes from the remaining list
        Node current = head;

        while (current != null && current.next != null) {

            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

    // Insert node at the end
    static Node addLast(Node head, int value) {

        Node newNode = new Node(value);

        if (head == null) {
            return newNode;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        return head;
    }

    // Display linked list
    static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Node head = null;

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();

        System.out.println("Enter order codes:");

        for (int i = 0; i < n; i++) {
            head = addLast(head, sc.nextInt());
        }

        System.out.print("Enter cancelled order code: ");
        int code = sc.nextInt();

        head = removeAll(head, code);

        System.out.println("Updated Order List:");
        display(head);

        sc.close();
    }
}