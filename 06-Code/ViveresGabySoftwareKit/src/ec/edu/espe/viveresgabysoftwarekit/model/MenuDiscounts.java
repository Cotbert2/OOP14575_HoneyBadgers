package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MenuDiscounts {

    private static Scanner scanner = new Scanner(System.in);
    private int option;
    private List<SeasonalDiscount> discounts;

    public MenuDiscounts() {
        this.discounts = new ArrayList<>();
    }

    public void handleMenuDiscounts() {
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
                    showDiscountHistory();
                    break;

                case 2:
                    System.out.println("You selected Create Discount");
                    createDiscount();
                    break;

                case 3:
                    System.out.println("You selected Delete Discount");
                    deleteDiscount();
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

    private void showDiscountHistory() {
        if (discounts.isEmpty()) {
            System.out.println("No discounts available.");
        } else {
            System.out.println("Discounts History:");
            for (SeasonalDiscount discount : discounts) {
                System.out.println(discount);
            }
        }
    }

    private void createDiscount() {
        System.out.print("Do you want to add a discount manually? (1 for Yes, 2 for No): ");
        int manualOption = getOption();

        if (manualOption == 1) {
            if (discounts.size() < 10) {
                System.out.print("Enter new discount (Father's Day, Mother's Day, Christmas, New Year, Carnival): ");
                String englishDate = Validations.validateStringInputWithSpaces("Enter the discount: ");

                System.out.print("Enter the discount value (between 2.00 and 8.00): ");
                double discountValue = Validations.validateDoubleDiscountInput("Enter the discount value: ");

                SeasonalDiscount newDiscount = new SeasonalDiscount(englishDate, discountValue);
                discounts.add(newDiscount);

                System.out.println("Creating discount for " + englishDate + ": " + String.format("%.2f", discountValue) + "%");
            } else {
                System.out.println("You have reached the maximum limit of discounts (10 per season).");
            }
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
            SeasonalDiscount newDiscount = new SeasonalDiscount(date, randomDiscount);
            discounts.add(newDiscount);

            System.out.println("Creating discount for " + date + ": " + String.format("%.2f", randomDiscount) + "%");
        }
    }

    private void deleteDiscount() {
        if (discounts.isEmpty()) {
            System.out.println("No discounts available to delete.");
        } else {
            System.out.println("Select a discount to delete:");
            showDiscountHistory();

            System.out.print("Enter the index of the discount to delete (0 to cancel): ");
            int index = Validations.validateIntInput("Enter the index: ");

            if (index >= 1 && index <= discounts.size()) {
                SeasonalDiscount deletedDiscount = discounts.remove(index - 1);
                System.out.println("Deleted discount: " + deletedDiscount);
            } else if (index != 0) {
                System.out.println("Invalid index, no discount deleted.");
            }
        }
    }
}

