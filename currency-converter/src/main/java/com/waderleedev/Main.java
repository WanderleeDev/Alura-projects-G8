package com.waderleedev;

import com.waderleedev.services.ApiRequestService;
import com.waderleedev.services.CurrencyService;
import com.waderleedev.services.IApiRequestService;
import com.waderleedev.services.ICurrencyService;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var board = new Scanner(System.in).useLocale(Locale.US);
        IApiRequestService apiRequestService = new ApiRequestService();
        ICurrencyService CurrencyService = new CurrencyService(apiRequestService);

        System.out.println("Currency converter".toUpperCase());

        while (true) {
            System.out.print("\nChoose an option:\n");
            System.out.println("\n1 - View currencies");
            System.out.println("2 - Convert currency");
            System.out.println("3 - Exit");


            if (!board.hasNextInt()) {
                System.out.println("\nInvalid option, try again\n".toUpperCase());
                board.nextLine();
                continue;
            }

            var option = board.nextInt();
            board.nextLine();

            if (option == 3) {
                System.out.println("Goodbye, please come again!");
                break;
            }

            switch (option) {
                case 1 -> CurrencyService.viewCurrencies();
                case 2 -> {
                    System.out.print("Enter the source currency: ");
                    String sourceCurrency = board.next().toUpperCase();
                    System.out.print("Enter the target currency: ");
                    String targetCurrency = board.next().toUpperCase();

                    while (true) {
                        System.out.print("Enter the amount: ");
                        try {
                            BigDecimal amount = board.nextBigDecimal();

                            if (!board.hasNextBigDecimal() || amount.compareTo(BigDecimal.ZERO) <= 0) {
                                System.out.println("\nInvalid amount, enter again a valid amount: \n".toUpperCase());
                                board.nextLine();
                                continue;
                            }

                            CurrencyService.calculateExchange(sourceCurrency, targetCurrency, amount);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("\nInvalid amount, enter again a valid amount: \n".toUpperCase());
                            board.nextLine();
                        }
                    }

                }
                default -> {
                    System.out.println("\nInvalid option\n".toUpperCase());
                    board.next();
                }
            }
        }

        board.close();
    }
}