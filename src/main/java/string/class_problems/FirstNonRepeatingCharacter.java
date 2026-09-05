package string.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Finds the first character that occurs only once
    public static char findFirstNonRepeatingChar(String text) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Step 1: Count frequency of every character
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Scan from left to right
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        // No non-repeating character found
        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println(
                    "First Non-Repeating Character: '" + result + "'"
            );
        }

        sc.close();
    }
}
