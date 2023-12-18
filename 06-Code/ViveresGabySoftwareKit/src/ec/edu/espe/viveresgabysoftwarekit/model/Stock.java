package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.utils.FileHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author mateo, Stefany Díaz
 */
public class Stock {
    List<SubStock> fullStorages;
    FileHandler<SubStock> fileHandler = new FileHandler<>();

    public Stock() {
        fullStorages = fileHandler.readJSONListStock(Constans.STOCK_FILE_NAME);
    }

    public void addStockToGrocery(int id, int units) {
        for (SubStock subStock : fullStorages) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnGroceryUnits(subStock.getOnGroceryUnits() + units);
            }
        }
    }

    public void addStockToWarehouse(int id) {
        for (SubStock subStock : fullStorages) {
            if (subStock.getProduct().getId() == id) {
                subStock.setOnStorageUnits(subStock.getOnStorageUnits() + subStock.getOnGroceryUnits());
                subStock.setOnGroceryUnits(0);
            }
        }
    }

    public void generateStockReport() {
        String report = "-------------------------------\n";
        report += "|        Stock Report           |\n";
        report += "-------------------------------\n";
        report += "Id" + "\tName" + "\tGrocery Units"  + "\tStorage Units" + "\tFull storage\n";
        for (SubStock subStock : fullStorages) {
            System.out.println(subStock.getOnGroceryUnits());
            System.out.println(subStock.getOnGroceryUnits());
            report += subStock.getProduct().getId() + " \t\t"  +subStock.getProduct().getName() + " " + " \t\t" + subStock.getOnGroceryUnits() + " \t\t" + subStock.getOnStorageUnits() + " \t\t" + (subStock.getOnStorageUnits() + subStock.getOnGroceryUnits()) +"\n";
        }
        Date date = new Date();
        fileHandler.saveTXTFile(report, Constans.OUTPUT_ROOT_FILE + "/StockReport_"+date.getDay()+ "_" +date.getMonth()+ "_" +date.getYear()+ "_" + date.getMinutes() + "_"+ date.getSeconds()+ ".txt" );
    }
}
