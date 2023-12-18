package ec.edu.espe.viveresgabysoftwarekit.view;
import ec.edu.espe.viveresgabysoftwarekit.model.*;


import java.util.Scanner;

import javax.mail.MessagingException;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class ViveresGabySoftwareKit {
    private static Scanner scanner = new Scanner(System.in);

    private static Market market;

    static {
        try {
            market = new Market();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws MessagingException {
        LogInSystem logInSystem = new LogInSystem();
        //logInSystem.showLogin();
        showMenu();
    }

    public static int showMenu() throws MessagingException {
        int option;
        do {
            System.out.println("----- Principal Menu -----");
            System.out.println("1. Market");
            System.out.println("2. Inventory");
            System.out.println("3. Financer");
            System.out.println("4. Discounts");
            System.out.println("5. Leave the program");
            System.out.print("Choose an option (1-5): ");

            option = obtenerOpcion();

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
                    MenuFinancer menuFinancer = new MenuFinancer();
                    menuFinancer.handMenuFinancer();
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println("You Selected Discounts");
                    
                    MenuDiscounts menuDiscounts = new MenuDiscounts();
                    menuDiscounts.handleMenuDiscounts();
                    
                    break;
                case 5:
                    System.out.println("-------------------------------------");
                    System.out.println("Thank you, we hope to see you soon...");
                    break;
                default:
                    System.out.println("-------------------------");
                    System.out.println("Invalid option, try again.");
            }

        } while (option != 5);

        return option;
    }

    private static int obtenerOpcion() {
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
