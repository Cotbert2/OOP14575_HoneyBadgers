package ec.edu.espe.viveresgabysoftwarekit.controller;
import ec.edu.espe.viveresgabysoftwarekit.view.InventoryMenu;
import java.util.Scanner;

/**
 * @autor Alex Cuzco, HoneyBadgers, DCCO-ESPE
 */

public class ViveresGabySoftwareKit {
    
        private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Market");
            System.out.println("2. Inventory");
            System.out.println("3. Financer");
            System.out.println("4. Discounts");
            System.out.println("5. go out");
            System.out.print("Choose an option (1-5): ");

            opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("You Selected Market");
                    
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
                    
                    break;
                case 4:
                    System.out.println("----------------------");
                    System.out.println("You Selected Discounts");
                    
                    break;
                case 5:
                    System.out.println("-------------------------------------");
                    System.out.println("thank you, we hope to see you soon...");
                    break;
                default:
                    System.out.println("-------------------------");
                    System.out.println("invalid option, try again.");
            }

        } while (opcion != 5);
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


