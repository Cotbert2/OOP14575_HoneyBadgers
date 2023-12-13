package ec.edu.espe.viveresgabysoftwarekit.view;

import java.util.Scanner;

import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;

public class Market {
    Scanner in = new Scanner(System.in);
    static Validator validator = new Validator();

    public static int marketMainMenu() {
        int option = 0;
        System.out.println("----- Market Menu -----");
        System.out.println("1) Sell");
        System.out.println("2) Delete Sell");
        System.out.println("3) Back");
        do {
            option = validator.getIntOption();
            if (option < 1 || option > 3)
                System.out.print("Invalid option, try again: ");

        } while (option < 1 || option > 3);
        return option;

    }

    public int newSellMenu() {
        System.out.println("----- New Sell Menu -----");
        System.out.println("1) Add Product");
        System.out.println("2) Delete Product");
        System.out.println("3) Next");
        System.out.println("4) Back");
        return validator.getIntOption();
    }

    public int verificationMenu() {
        System.out.println("Are you sure you want to cancel (y/n): ");
        return validator.getYNOption();
    }

    //TODO: Refactor function
    public int newSellProductAdd() {
        System.out.println("name: ");
        String name = in.nextLine();
        //TODO: Find Product
        System.out.println("Add: ");
        System.out.println("quantity: ");
        return 0;
    }

    public int newSellProductDeleteMenu(String[] items) {
        System.out.println("----- Delete Product Menu -----");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ") " + items[i]);
        }
        System.out.println(items.length + 1 + ") Back");
        System.out.print("Select an option: ");
        return validator.getIntOption();
    }


}
