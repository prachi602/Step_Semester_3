package string.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    // Approach 1: Iterative comparison
    public static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text) {

        return checkRecursive(text, 0, text.length() - 1);
    }

    private static boolean checkRecursive(String text, int left, int right) {

        // Base case
        if (left >= right) {
            return true;
        }

        // Characters don't match
        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        // Check the remaining substring
        return checkRecursive(text, left + 1, right - 1);
    }

    // Approach 3: Array reversal
    public static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        String reversedText = new String(reversed);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or text: ");
        String text = sc.nextLine();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println();

        System.out.println("Iterative: "
                + (iterativeResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (recursiveResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (arrayResult ? "Palindrome" : "Not Palindrome"));

        // Verify that all three approaches agree
        if (iterativeResult == recursiveResult &&
                recursiveResult == arrayResult) {

            System.out.println("\nAll three approaches agree.");
        } else {

            System.out.println("\nError: The approaches produced different results.");
        }

        sc.close();
    }
}