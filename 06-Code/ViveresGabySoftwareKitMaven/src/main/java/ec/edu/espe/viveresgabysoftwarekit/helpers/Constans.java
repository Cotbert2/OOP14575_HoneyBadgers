package ec.edu.espe.viveresgabysoftwarekit.helpers;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class Constans {
    public static final String OUTPUT_ROOT_FILE = "./output";
    public static final String USERS_FILE_NAME = "users";
    public static final String PRODUCTS_FILE_NAME = "products";
    public static final String CUSTOMERS_FILE_NAME = "customers";
    public static final String WELCOME_HEADER = "**************************************************\n" +
            "|  WELCOME TO VIVERES GABY SOFTWARE KIT           |\n" +
            "**************************************************";
    public static final String HEADER = "**************Viveres Gaby Software Kit**************";
    public static final String BILLS_FILE_NAME = "bills";
    public static final String CATEGORIES_FILE_NAME = "categories";

    public static final String DISCOUNTS_FILE_NAME = "discounts";
    public static final String TRANSACTION_FILE = "transactions";
    public static final String TAXES_FILE_NAME = "taxes";
    public static final String STOCK_FILE_NAME = "stock";
    public static final String IVA_URL = "https://www.sri.gob.ec/impuesto-al-valor-agregado-iva";

    public static final String VIVERES_GABY_LANDING_PAGE = "https://658031b74f9e7f3203fb2d25--cheery-eclair-b46b9a.netlify.app/";

    
    
    
    public static final String DATA_BASE = "viveres_gaby_software_kit_DB";
    public static final String URI = "mongodb+srv://mateo:mateo@cluster0.jp3jhno.mongodb.net/?retryWrites=true&w=majority";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
