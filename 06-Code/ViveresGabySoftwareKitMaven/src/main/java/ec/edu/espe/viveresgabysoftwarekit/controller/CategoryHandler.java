package ec.edu.espe.viveresgabysoftwarekit.controller;

import ec.edu.espe.viveresgabysoftwarekit.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */
public class CategoryHandler {

    private List<Category> categoryList = new ArrayList<>();
    Category category = new Category("", "");

    public void updateCategory() {
        categoryList = category.getCategories();
    }

    public List<Category> getCategoryList() {
        updateCategory();
        return categoryList;
    }
    
    
}
