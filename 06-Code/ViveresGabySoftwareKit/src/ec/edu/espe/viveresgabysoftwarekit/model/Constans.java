package ec.edu.espe.viveresgabysoftwarekit.model;

public class Constans {

    public static final String OUTPUT_ROOT_FILE = "./output";
    public static final String USERS_FILE_NAME= "./db/users.json";
    public static final String PRODUCTS_FILE_NAME= "./db/products.json";
    public static final String CUSTOMERS_FILE_NAME= "./db/customers.json";
    public static final String WELCOME_HEADER = "********** WELCOME TO VIVERES GABY SOFTWARE KIT **********";
    public static final String HEADER = "**************Viveres Gaby Software Kit**************";
    public static final String BILLS_FILE_NAME = "./db/bills.json";
    public static final String CATEGORIES_FILE_NAME = "./db/categories.json";

    public static final String DISCOUNTS_FILE_NAME = "./db/discounts.json";
    public static final String TRANSACTION_FILE = "./db/transactions.json";
    public static final String TAXES_FILE_NAME = "./db/taxes.json";
    public static final String STOCK_FILE_NAME = "./db/stock.json";
    public static final String IVA_URL = "https://www.sri.gob.ec/impuesto-al-valor-agregado-iva";


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
