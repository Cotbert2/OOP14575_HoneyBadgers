package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.PdfConverter;

import java.util.Date;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */
public class Stock {
    private List<SubStock> fullStorages;
    DbManager<SubStock> fileHandler = new DbManager<>();

    public Stock() {
        fullStorages = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
    }

    public void addStockToGrocery(int id, int units) {
        for (SubStock subStock : fullStorages) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnGroceryUnits(subStock.getOnGroceryUnits() + units);
            }
        }
        saveStockFullList(fullStorages);
    }

    public void addStockToWarehouse(int id, int units) {
        for (SubStock subStock : fullStorages) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnStorageUnits(subStock.getOnStorageUnits() + units);
            }
        }
        saveStockFullList(fullStorages);
    }

    public void generateStockReport() {
        String report = "-------------------------------\n";
        report += "|        Stock Report           |\n";
        report += "-------------------------------\n";
        report += "Id" + "\tName" + "\tGrocery Units"  + "\tStorage Units" + "\tFull storage\n";
        for (SubStock subStock : fullStorages) {
            report += subStock.getProduct().getId() + " \t\t"  +subStock.getProduct().getName() + " " + " \t\t" + subStock.getOnGroceryUnits() + " \t\t" + subStock.getOnStorageUnits() + " \t\t" + (subStock.getOnStorageUnits() + subStock.getOnGroceryUnits()) +"\n";
        }
        Date date = new Date();
        String filePath = fileHandler.getDesktopPath() + "/StockReport_"+date.getDay()+ "_" +date.getMonth()+ "_" +date.getYear()+ "_" + date.getMinutes() + "_"+ date.getSeconds()+ ".txt";
        fileHandler.saveTXTFile(report, filePath);

        PdfConverter pdfConverter = new PdfConverter();
        pdfConverter.convert(filePath);

        System.out.println("-----------------------------------------");
        System.out.println("|   [+] Stock Report Saved On Desktop   |");
        System.out.println("-----------------------------------------");
    }

    public List<SubStock> getStocks(){
        return fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
    }

    public void saveStocks(SubStock newStockItem){
        List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        fullStock.add(newStockItem);
        fileHandler.saveCollection(fullStock, Constans.STOCK_FILE_NAME);
    }

    public void saveStockFullList(List<SubStock> stockStore){
        fileHandler.saveCollection(stockStore, Constans.STOCK_FILE_NAME);
    }

    public int getStockUnits(int id){
        List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        for (SubStock subStock : fullStock) {
            if (subStock.getProduct().getId() == id) {
                return subStock.getOnGroceryUnits() + subStock.getOnStorageUnits();
            }
        }
        return 0;
    }


    public int getGroceryUnits (int id){
        List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        for (SubStock subStock : fullStock) {
            if (subStock.getProduct().getId() == id) {
                return subStock.getOnGroceryUnits();
            }
        }
        return 0;
    }

    public void updateStockItem(int id, int units, int storageUnits){
        List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        for (SubStock subStock : fullStock) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnGroceryUnits(units);
                subStock.setOnStorageUnits(storageUnits);
            }
        }
        saveStockFullList(fullStock);
    }


    public void stockHandlerBySell(int id, int quantity){
        List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        for (SubStock subStock : fullStock) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnGroceryUnits(subStock.getOnGroceryUnits() - quantity);
                if (quantity > subStock.getOnGroceryUnits()){
                    subStock.setOnStorageUnits(subStock.getOnStorageUnits() - (quantity - subStock.getOnGroceryUnits()));
                    subStock.setOnGroceryUnits(0);
                }
            }
        }
        saveStockFullList(fullStock);
    }

    public void getProductStockSummary(int id){
            List<SubStock> fullStock = fileHandler.readJSONListGeneric(Constans.STOCK_FILE_NAME, SubStock.class);
        for (SubStock subStock : fullStock) {
            if (subStock.getProduct().getId() == id) {
                System.out.println("Product: " + subStock.getProduct().getName());
                System.out.println("Grocery Units: " + subStock.getOnGroceryUnits());
                System.out.println("Storage Units: " + subStock.getOnStorageUnits());
                System.out.println("Total Units: " + (subStock.getOnGroceryUnits() + subStock.getOnStorageUnits()));
            }
        } }
}
