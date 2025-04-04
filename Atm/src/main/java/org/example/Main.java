package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Double balance = 1599.99;
    static Scanner board = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {
            try {
                showMenu();

                int selectedOption = board.nextInt();

                if (selectedOption == 4) {
                    System.out.println("Goodbye");
                    break;
                }

                handleAtmOperation(selectedOption);
            } catch (InputMismatchException e) {
                handleBoardError(e);
            }
        }
    }

    private static void showMenu() {
        System.out.println("""
                   ==========================
                       Welcome STARS BANK
                   ==========================
                   1: Check balance
                   2: Withdraw money
                   3: Deposit money
                   4: Exit
                   ==========================
                   Enter your option:
                """);
    }

    private static void handleAtmOperation(int option) {
        if (option <= 0 || option > 4) {
            System.out.println("Invalid option");
            return;
        }

        switch (option) {
            case (1) -> showBalance();
            case (2) -> withdrawFunds();
            case (3) -> deposit();
            default -> System.out.println("Invalid option");
        }
    }

    private static void withdrawFunds() {
        while (true) {
            showBalance();
            System.out.println("Enter the amount to withdraw:");

            try {
                double amount = board.nextDouble();

                if (amount <= balance && amount > 0) {
                    balance -= amount;
                    System.out.println("Withdrawal successful:" + amount);
                    showBalance();
                    break;
                }

                System.out.println("Invalid amount");
            } catch (InputMismatchException e) {
                handleBoardError(e);
            }
        }

    }

    private static void deposit() {
        while (true) {
            showBalance();
            System.out.println("Enter the amount to deposit:");

            try {
                double amount = board.nextDouble();

                if (amount > 0) {
                    balance += amount;
                    showBalance();
                    break;
                }

                System.out.println("Invalid amount");
            } catch (InputMismatchException e) {
                handleBoardError(e);
            }
        }
    }

    private static void showBalance() {
        System.out.println("Your current balance is " + balance);
    }

    private static void handleBoardError(Exception error) {
        System.out.println(error.getMessage());
        board.next();
    }
}
