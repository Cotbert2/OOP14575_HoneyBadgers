package ec.edu.espe.viveresgabysoftwarekit.controller;
//import ec.espe.edu.viveresgabysoftware.view.MenuDiscounts;
import ec.espe.edu.viveresgabysoftware.view.MenuFinancer;
import ec.espe.edu.viveresgabysoftware.view.InventoryMenu;

/**
 * @autor Mateo, Stefany Díaz
 */

public class ViveresGabySoftwareKit {

        public static void main(String[] args) {
            MenuFinancer menu = new MenuFinancer();
            menu.handMenuFinancer();
            InventoryMenu menu1= new InventoryMenu();
            menu1.displayMenu();
            
            
            //MenuDiscounts menu1 = new MenuDiscounts();
            //menu1.handMenuDiscounts();//
                    
                
        }
}