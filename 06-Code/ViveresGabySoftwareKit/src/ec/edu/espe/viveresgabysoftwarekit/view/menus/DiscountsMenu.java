package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import ec.edu.espe.viveresgabysoftwarekit.model.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Discount;
import ec.edu.espe.viveresgabysoftwarekit.model.SeasonalDiscount;
import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;
import ec.edu.espe.viveresgabysoftwarekit.utils.Validations;

import java.util.*;


/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class DiscountsMenu {

    private static Scanner scanner = new Scanner(System.in);
    private int option;

    private List<Discount> SDiascounts;





    //TODO:Delete
    private List<SeasonalDiscount> discounts;



    FileHandler<Discount> fileHandlerDiscounts = new FileHandler<>();

    public DiscountsMenu() {
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
        updateSeasonalDiscounts();
        if (SDiascounts.isEmpty()) {
            System.out.println("No discounts available.");
        } else {
            System.out.println("Discounts History:");
            for (Discount discount : SDiascounts) {
                discount.UIPrint();
            }
        }
    }

    private void createDiscount() {
        String discountName = Validations.noValidationStr("Enter the name of the discount: ");
        float discountValue = Validations.validateDiscountInput("Enter the porcentage of the discount: ");
        String startDate = Validations.validateDate("Enter the start date of the discount (dd/MM/yyyy): ");
        String endDate = Validations.validateDate("Enter the end date of the discount (dd/MM/yyyy): ");
        Date startDateFormated = new Date(startDate);
        Date endDateFormated = new Date(endDate);
        int discountId = getLastIdDiscount() + 1;
        Discount newDiscount = new Discount(discountId,discountName, discountValue, startDateFormated, endDateFormated);
        System.out.println("New discount created successfully: ");
        newDiscount.UIPrint();
        newDiscount.saveDiscount();
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






    public void updateSeasonalDiscounts(){
        SDiascounts = fileHandlerDiscounts.readJSONListDiscounts(Constans.DISCOUNTS_FILE_NAME);
    }

    public int getLastIdDiscount(){
        return fileHandlerDiscounts.readJSONListDiscounts(Constans.DISCOUNTS_FILE_NAME).getLast().getId();
    }
}

