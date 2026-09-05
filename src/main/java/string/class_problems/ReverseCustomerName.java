package string.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    // Reverses the customer name
    public static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        StringBuilder reversedName = new StringBuilder();

        for (int i = characters.length - 1; i >= 0; i--) {
            reversedName.append(characters[i]);
        }

        return reversedName.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}