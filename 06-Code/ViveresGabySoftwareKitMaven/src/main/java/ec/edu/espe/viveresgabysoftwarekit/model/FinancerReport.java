package ec.edu.espe.viveresgabysoftwarekit.model;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import ec.edu.espe.viveresgabysoftwarekit.utils.PdfConverter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @autor Alex Cuzco, Stefany Díaz, Eduardo García, Matego García-HONEYBUDGERS-DCCO-14575
 */

public class FinancerReport {
    private List<Bill> bills;
    private ArrayList<Tax> taxes;

    public FinancerReport() {
        DbManager<Bill> fileHandler = new DbManager<>();
        this.bills = fileHandler.readJSONListGeneric(Constans.BILLS_FILE_NAME, Bill.class);

    }

    public void generateFinancerReport() {
        String report = "---------------------------------------------\n" +
                        "|               Financer Report              |\n" +
                "---------------------------------------------\n" +
                "Bills\n" +
                "---------------------------------------------\n";

        //print bills
        float totalEarnings = 0;
        float totalTaxes = 0;
        float totalSell = 0;

        for (Bill bill : bills) {
            bill.computeTotalPrice();
            report += bill.getId() + " ";
            if (bill.getCustomer() == null)
                report += "Final Customer";
            else
                report += bill.getCustomer().getFullname() + " ";
            report += bill.getPurchaseDay() + " " + bill.getTotalPrice() + " " + bill.getTotalEarnings() + bill.getTotalPrice() * 0.12f + "\n";
            totalEarnings += bill.getTotalEarnings();
            totalTaxes += bill.getTotalPrice() * 0.12f;
            totalSell += bill.getTotalPrice();
        }
        report += "---------------------------------------------\n" +
                "Number of Bills: " + bills.size() + "\n" +
                "Total Earnings: " + totalEarnings + "\n" +
                "Total Taxes: " + totalTaxes + "\n" +
                "Total Sell: " + totalSell + "\n" +
                "---------------------------------------------\n";

        DbManager<FinancerReport> fileHandler = new DbManager<>();
        Date date = new Date();
        String fileName = fileHandler.getDesktopPath()+ "/FinancerReport" +date.getDay()+ "_" +date.getMonth()+ "_" +date.getYear()+ "_" + date.getMinutes() + "_"+ date.getSeconds()+ ".txt";
        fileHandler.saveTXTFile(report, fileName);
        PdfConverter pdfConverter = new PdfConverter();
        pdfConverter.convert(fileName);
    }

}
