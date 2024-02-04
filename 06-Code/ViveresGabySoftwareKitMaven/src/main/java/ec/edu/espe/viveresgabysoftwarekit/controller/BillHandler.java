package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Bill;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import java.util.List;

/**
 *
 * @author mateo
 */
public class BillHandler {

    private List<ec.edu.espe.viveresgabysoftwarekit.model.Bill> allBills;
    DbManager<ec.edu.espe.viveresgabysoftwarekit.model.Bill> dbManager = new DbManager<>();

    public void updateBillsInfo() {
        allBills = dbManager.readJSONListGeneric(Constans.BILLS_FILE_NAME, Bill.class);
    }

    public List<ec.edu.espe.viveresgabysoftwarekit.model.Bill> getAllBills() {
        updateBillsInfo();
        return allBills;
    }
    
    
}
