package src;

import java.util.Scanner;

public class BankingApp {
    public static void main() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("What amount of funds would you like to start with?");
        double startAmount = scanner.nextDouble();

        var client = new Client(name, new BankAccount(startAmount));

        while (true) {
            System.out.println("\n=== BankingApp Menu ===");
            System.out.println("1. Make Withdrawal");
            System.out.println("2. Make Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    makeWithdrawal(client, amount);
                }
                case 2 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    makeDeposit(client, amount);
                }
                case 3 -> {
                    System.out.println("Check the balance...");
                    checkBalance(client);
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void makeWithdrawal(Client client, double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        System.out.println("Attempt to make a withdrawal...");
        try {
            client.account().withdraw(amount);
            System.out.println("Successfully made a withdrawal.");
            checkBalance(client);
        } catch (RuntimeException e) {
            System.out.println("Failed to withdraw funds: " + e.getMessage());
        }
    }

    private static void makeDeposit(Client client, double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }

        System.out.println("Attempt to make a deposit...");
        client.account().deposit(amount);
        System.out.println("Successfully made a deposit.");
        checkBalance(client);
    }

    private static void checkBalance(Client client) {
        client.account().printBalance();
    }
}
