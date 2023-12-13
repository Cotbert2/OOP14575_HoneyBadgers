
package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.Scanner;

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
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z]+")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a non-empty string with only letters.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public static String validateStringInputWithSpaces(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z\\s]+")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter letters and spaces only.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public static double validateDiscountInput(String prompt) {
        double input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                String inputStr = scanner.nextLine();
                input = Double.parseDouble(inputStr);

                if (input >= 0 && input <= 100) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid discount percentage (0-100).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!validInput);

        return input;
    }

    public static int validateSoldQuantity(String productName, int currentStock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static String validateProductName(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z\\s]{3,}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a non-empty string with more than 3 letters.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public static String validateDescription(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z\\s]{3,}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a non-empty string with more than 3 letters.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public static String validateProvider(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z\\s]{3,}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a non-empty string with more than 3 letters.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public static String validateCategory(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z\\s]{3,}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a non-empty string with more than 3 letters.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }
    public static double validateDoubleDiscountInput(String prompt) {
    while (true) {
        try {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();
            double input = Double.parseDouble(inputStr);

            if (input >= 2.00 && input <= 8.00) {
                return input;
            } else {
                System.out.print("Invalid discount value, try again (between 2.00 and 8.00): ");
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid entry, try again: ");
        }
    }
  }
    public static int validateQuantityInput(String prompt, int maxQuantity) {
    int input = 0;
    boolean validInput = false;

    do {
        try {
            System.out.print(prompt);
            String inputStr = scanner.nextLine();
            input = Integer.parseInt(inputStr);

            if (input >= 1 && input <= maxQuantity) {
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid quantity (1-" + maxQuantity + ").");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    } while (!validInput);

    return input;
}

    public static int validateProductQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}



