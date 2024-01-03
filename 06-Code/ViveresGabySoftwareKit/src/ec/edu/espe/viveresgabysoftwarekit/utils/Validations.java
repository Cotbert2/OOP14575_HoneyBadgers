
package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Validations {

    private static final Scanner scanner = new Scanner(System.in);

    public static int obtainOptionInventory() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 7) {
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

    public static float validateFloatInput(String prompt) {
        float input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                String inputStr = scanner.nextLine();
                input = Float.parseFloat(inputStr);
                if (input > 0)
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

    public static float validateDiscountInput(String prompt) {
        float input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt);
                String inputStr = scanner.nextLine();
                input = Float.parseFloat(inputStr);

                if (input > 0 && input < 100) {
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

    public static String getNoValidationStr(String cad) {
        System.out.print(cad);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String getNoValidationLongStr(String cad) {
        String input;
        do {
            System.out.print(cad);
            input = scanner.nextLine();
            if (input.isEmpty())
                System.out.println("Invalid input, please try again.");
        }while(input.isEmpty());
        return  input;
    }

    public static String validateDate(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a valid date (dd/mm/yyyy).");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public String validateEmail(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.([a-zA-Z]{2,4})+")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a valid email.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public String validatePhone(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();

                if (!input.isEmpty() && input.matches("^(09)[0-9]{8}")) {
                    return input;
                } else {
                    System.out.println("Invalid input, please enter a valid phone number.");
                }
            } catch (Exception e) {
                System.out.print("Invalid entry, try again: ");
            }
        }
    }

    public boolean getYNOption(String prompt) {
        System.out.print(prompt);
        String option = "";
        while (true) {
            option = scanner.nextLine();
            if (option.equalsIgnoreCase("y")) {
                return true;
            } else if (option.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.print("Invalid option, try again: ");
            }
        }
    }

    public static int getIntPositiveOption(String prompt) {
        System.out.print(prompt);
        boolean validNum = false;
        int option = 0;
        while (!validNum) {
            try {
                option = scanner.nextInt();
                if (option < 0) {
                    System.out.print("Invalid option, try again: ");
                } else {
                    validNum = true;
                }
            } catch (InputMismatchException e) {
                System.out.print("Invalid option, try again: ");
                scanner.nextLine();
            }
        }
        return option;
    }

    public int getIntOption(String prompt) {
        System.out.print(prompt);
        boolean validNum = false;
        int option = 0;
        while (!validNum) {
            try {
                option = scanner.nextInt();
                validNum = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid option, try again: ");
                scanner.nextLine();
            }
        }
        return option;
    }

}
