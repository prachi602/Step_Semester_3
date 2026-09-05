package string.class_problems;

import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {

        // Check whether the phone number has exactly 10 digits
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check whether every character is a digit
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get the last four digits
        String lastFourDigits = phone.substring(6);

        // Create the masked number
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");

        // Insert '-' before the last four digits
        maskedNumber.insert(6, "-");
        maskedNumber.append(lastFourDigits);

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));

        sc.close();
    }
}