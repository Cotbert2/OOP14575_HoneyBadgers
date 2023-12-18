package ec.edu.espe.viveresgabysoftwarekit.view.menus;

import ec.edu.espe.viveresgabysoftwarekit.model.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.Opener;

import javax.mail.MessagingException;
import java.util.Scanner;

public class MainMenu {

    private static Scanner scanner = new Scanner(System.in);

    private static Market market;

    static {
        try {
            market = new Market();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static int showMenu() throws MessagingException {
        int option;
        do {
            System.out.println("----- Principal Menu -----");
            System.out.println("1. Market");
            System.out.println("2. Inventory");
            System.out.println("3. Financer");
            System.out.println("4. Discounts");
            System.out.println("5. About us");
            System.out.println("6. Leave the program");
            System.out.print("Choose an option (1-5): ");

            option = getOption();

            switch (option) {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("You Selected Market");
                    int opt = market.marketMainMenu();

                    break;
                case 2:
                    System.out.println("-----------------------");
                    System.out.println("You Selected Inventory");

                    InventoryMenu inventoryMenu = new InventoryMenu();
                    inventoryMenu.displayMenu();
                    break;
                case 3:
                    System.out.println("---------------------");
                    System.out.println("You Selected Financer");
                    FinancerMenu financerMenu = new FinancerMenu();
                    financerMenu.handMenuFinancer();
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println("You Selected Discounts");

                    DiscountsMenu discountsMenu = new DiscountsMenu();
                    discountsMenu.handleMenuDiscounts();

                    break;
                case 5:
                    System.out.printf("Opening the landing page...");
                    Opener opener = new Opener();
                    opener.openWebpage(Constans.VIVERES_GABY_LANDING_PAGE);
                    break;
                case 6:
                    System.out.println("-------------------------------------");
                    System.out.println("Thank you, we hope to see you soon...");
                    break;
                default:
                    System.out.println("-------------------------");
                    System.out.println("Invalid option, try again.");
            }

        } while (option != 6);

        return option;
    }

    private static int getOption() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 5) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }
}
