package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;
import java.util.Random;
import java.util.Scanner;

public class MenuDiscounts {

    private static Scanner scanner = new Scanner(System.in);
    private int option;

    public void handMenuDiscounts() {
        do {
            System.out.println("---- Discounts Menu ----");
            System.out.println("1. History");
            System.out.println("2. Create Discount");
            System.out.println("3. Delete Discount");
            System.out.println("4. Return to principal menu");
            System.out.print("Choose an option: ");

            option = getOption();

            switch (option) {
                case 1:
                    System.out.println("You selected History");
                    doHistoryAction();
                    break;

                case 2:
                    System.out.println("You selected Create Discount");
                    doCreateDiscountAction();
                    break;

                case 3:
                    System.out.println("You selected Delete Discount");
                    doDeleteDiscountAction();
                    break;

                case 4:
                    System.out.println("Leaving to the principal menu...");
                    break;

                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option != 4);
    }

    private int getOption() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 4) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    private void doHistoryAction() {
        System.out.println("Discounts History");
        System.out.println("---- Discounts History Menu ----");
        System.out.println("1. View History");
        System.out.println("2. Add Discount");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }
    }

    private void doCreateDiscountAction() {
        System.out.println("Discount - Create");

        System.out.print("Do you want to add a discount manually? (1 for Yes, 2 for No): ");
        int manualOption = getOption();

        if (manualOption == 1) {
            System.out.print("Enter the date (Father's Day, Mother's Day, Christmas, New Year, Carnival): ");
            String englishDate = Validations.validateStringInputWithSpaces("Enter the date: ");

            System.out.print("Enter the discount value (between 2.00 and 8.00): ");
            double discountValue = Validations.validateDoubleDiscountInput("Enter the discount value: ");

            System.out.println("Creating discount for " + englishDate + ": " + String.format("%.2f", discountValue) + "%");
            // Puedes almacenar esta información en una estructura de datos o base de datos según tus necesidades
        } else if (manualOption == 2) {
            generateAutomaticDiscounts();
        } else {
            System.out.println("Invalid option, returning to the main menu.");
        }
    }

    private void generateAutomaticDiscounts() {
        String[] dates = {"Father's Day", "Mother's Day", "Christmas", "New Year", "Carnival"};
        Random random = new Random();

        for (String date : dates) {
            double randomDiscount = 2.00 + (random.nextDouble() * (8.00 - 2.00)); // Generar descuento aleatorio entre 2% y 8%
            System.out.println("Creating discount for " + date + ": " + String.format("%.2f", randomDiscount) + "%");
            // Puedes almacenar esta información en una estructura de datos o base de datos según tus necesidades
        }
    }

    private void doDeleteDiscountAction() {
        System.out.println("Discount Delete");
        System.out.println("---- Delete Discount Menu ----");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }
    }
}
