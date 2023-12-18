package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Validator {
    Scanner in = new Scanner(System.in);

    public int getIntOption() {
        boolean validNum = false;
        int option = 0;
        while (!validNum) {
            try {
                option = in.nextInt();
                validNum = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid option, try again: ");
                in.nextLine();
            }
        }
        return option;
    }

    public boolean getYNOption() {
        String option = "";
        while (true) {
            option = in.nextLine();
            if (option.equalsIgnoreCase("y")) {
                return true;
            } else if (option.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.print("Invalid option, try again: ");
            }
        }
    }

    public String getStr() {
        String str = in.nextLine();
        return str;
    }
}
