package ec.edu.espe.viveresgabysoftwarekit.view;

import java.util.Scanner;

import ec.edu.espe.viveresgabysoftwarekit.utils.Validator;

public class Market {
    Scanner in = new Scanner(System.in);
    static Validator validator = new Validator();

    public static int marketMainMenu() {
        int option = 0;
        int sellOption = 0;
        System.out.println("----- Market Menu -----");
        System.out.println("1) New Sell");
        System.out.println("3) Back");
        do {
            option = validator.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Sell");
                    sellOption = newSellMenu();
                    break;
                case 2:
                    System.out.println("Leaving to the principal menu...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }

        } while (option < 1 || option > 2);
        return option;

    }

    public static int newSellMenu() {
        System.out.println("----- New Sell Menu -----");
        System.out.println("1) Add Product");
        System.out.println("2) Delete Product");
        System.out.println("3) Next");
        System.out.println("4) Back");

        int option = 0;
        do {
            option = validator.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Add Product");
                    newSellProductAdd();
                    break;
                case 2:
                    System.out.println("You selected Delete Product");
                    break;
                case 3:
                    System.out.println("You selected Next");
                    newSellCustomer();
                    break;
                case 4:
                    System.out.println("You selected Back");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option < 1 || option > 4);
        return option;
    }

    public static int verificationMenu() {
        System.out.println("Are you sure you want to cancel (y/n): ");
        return validator.getYNOption();
    }

    public static int newSellProductAdd() {
        System.out.print("name: ");
        validator.getStr();
        System.out.println("add: ");
        validator.getIntOption();
        System.out.println("quantity: ");
        validator.getIntOption();
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

    public static int newSellCustomer(){
        System.out.println("----- New Sell-Customer -----");
        System.out.println("1) Data");
        System.out.println("2) Final Customer");
        System.out.println("3) Back");

        int option = 0;
        do {
            option = validator.getIntOption();
            switch (option) {
                case 1:
                    System.out.println("You selected Data");
                    break;
                case 2:
                    System.out.println("You selected Final Customer");
                    break;
                case 3:
                    System.out.println("You selected Back");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        } while (option < 1 || option > 4);
        return option;
    }

    public String getSring(){
        return in.nextLine();
    }

}
