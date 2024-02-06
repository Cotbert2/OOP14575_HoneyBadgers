package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.helpers.Constans;
import ec.edu.espe.viveresgabysoftwarekit.model.Discount;
import ec.edu.espe.viveresgabysoftwarekit.utils.DbManager;
import java.util.List;

/**
 *
 * @author mateo
 */
public class DiscountsHandler {

    DbManager<Discount> DbHandler = new DbManager<>();
    private List<Discount> SDiscounts;

    public List<Discount> getSDiascounts() {
        this.updateSeasonalDiscounts();
        return SDiscounts;
    }

    public void updateSeasonalDiscounts() {
        SDiscounts = DbHandler.readJSONListGeneric(Constans.DISCOUNTS_FILE_NAME, Discount.class);
    }


}
