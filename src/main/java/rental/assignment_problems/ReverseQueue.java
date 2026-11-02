package rental.assignment_problems;

import java.util.Scanner;

public class ReverseQueue {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    // Reverse linked list
    static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next;

            current.next = previous;

            previous = current;
            current = next;
        }

        return previous;
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

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.println("Enter queue elements:");

        for (int i = 0; i < n; i++) {
            head = addLast(head, sc.nextInt());
        }

        head = reverse(head);

        System.out.println("Reversed Queue:");
        display(head);

        sc.close();
    }
}