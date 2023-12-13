
package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.Scanner;

/**
 *
 * @author eduag
 */


public class Validations {

    private static Scanner scanner = new Scanner(System.in);

    public static int obtainOptionInventory() {
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

    public static int validateIntInput(String prompt) {
        int input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                String inputStr = scanner.nextLine();
                input = Integer.parseInt(inputStr);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        } while (!validInput);

        return input;
    }

    public static double validateDoubleInput(String prompt) {
        double input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                String inputStr = scanner.nextLine();
                input = Double.parseDouble(inputStr);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!validInput);

        return input;
    }

    public static String validateStringInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (input.matches("[a-zA-Z\\s]+")) {
                return input;
            } else {
                System.out.println("Invalid input, please enter letters only.");
            }
        }
    }

    public static int validateSoldQuantity(String productName, int currentStock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 }
