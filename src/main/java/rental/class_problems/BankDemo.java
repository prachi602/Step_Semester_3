
package rental.class_problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Account> accounts = new HashMap<>();

        System.out.println("Enter account operations:");
        System.out.println("Enter EXIT to stop.");

        while (sc.hasNextLine()) {

            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("EXIT")) {
                break;
            }

            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            if (parts[0].equalsIgnoreCase("Savings")) {

                String id = parts[1];
                double balance = Double.parseDouble(parts[2]);

                accounts.put(id, new SavingsAccount(id, balance));

            } else if (parts[0].equalsIgnoreCase("Current")) {

                String id = parts[1];
                double balance = Double.parseDouble(parts[2]);

                accounts.put(id, new CurrentAccount(id, balance));

            } else if (parts[0].equalsIgnoreCase("WITHDRAW")) {

                String id = parts[1];
                double amount = Double.parseDouble(parts[2]);

                Account account = accounts.get(id);

                if (account == null) {
                    System.out.println("Account not found");
                } else {
                    account.withdraw(amount);
                }
            }
        }

        sc.close();
    }
}

