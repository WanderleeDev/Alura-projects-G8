package com.xam.literalura;

import com.xam.literalura.services.AuthorDataSource;
import com.xam.literalura.services.BooksDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CliInterface {
    private final Scanner board = new Scanner(System.in);

    @Autowired
    private BooksDataSource booksDataSource;

    @Autowired
    private AuthorDataSource authorDataSource;

    private final String[] options = {
            "Search book",
            "List registered books",
            "List registered authors",
            "Lists of living authors in a given year",
            "Lists of books of a given author",
            "Exit"
    };

    public void run() {
        System.out.println("Welcome to Literalura\n".toUpperCase());

        while (true) {
            showMenu();

            System.out.print("Select an option: ");
            String input = board.nextLine().trim();

            try {
                int option = Integer.parseInt(input);

                if (option < 1 || option > options.length) {
                    System.out.println("\nInvalid option\n".toUpperCase());
                    continue;
                }

                this.optionManager(option);

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid option\n".toUpperCase());
            }
        }
    }

    public void showMenu() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < options.length; i++) {
            sb.append(String.format("%d.  %s %n", i+1, options[i]));
        }

        System.out.println(sb);
    }

    private void exitCli() {
        System.out.println("Goodbye!");
        board.close();
        System.exit(0);
    }

    private void optionManager(int option) {
        switch (option) {
            case 1 -> searchBook();
            case 2 -> booksDataSource.listBooks();
            case 3 -> authorDataSource.listAuthors();
            case 4 -> listAuthorsLivingInYear();
            case 5 -> booksDataSource.listBooksByAuthorLive();
            case 6 -> this.exitCli();
        }
    }

    private void searchBook() {
        System.out.println("Input search book: ");
        var bookSearched = board.nextLine();
        System.out.println("searching...");
        this.booksDataSource.searchBook(bookSearched);
    }

    private void listAuthorsLivingInYear() {
        while (true) {
            try {
                System.out.println("Input year: ");
                var bookSearched = Integer.parseInt(board.nextLine());
                this.authorDataSource.listAuthorsLiving(bookSearched);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year");
            }
        }
    }
}
