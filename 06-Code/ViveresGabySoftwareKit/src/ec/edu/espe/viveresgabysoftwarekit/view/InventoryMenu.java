
package ec.edu.espe.viveresgabysoftwarekit.view;
import java.util.Scanner;

/**
 *
 * @author Alex Cuzco, HoneyBadgers, DCCO-ESPE
 */
public class InventoryMenu {
    
    private static Scanner scanner = new Scanner(System.in);
    int optionInventory;
    
    public void displayMenu(){
    do {
        
        System.out.println("-----  Inventory Menu  -----");
        System.out.println("1. Add product");
        System.out.println("2. Delete Product");
        System.out.println("3. Add category");
        System.out.println("4. Delete category");
        System.out.println("5. See stock");
        System.out.println("6. Edit product");
        System.out.println("7. Edit stock");
        System.out.println("8. Edit category ");
        System.out.println("9. Return to principal menu");
        System.out.print("Choose a option: ");
                           
     optionInventory = obtainOptionInventory();
                            
    switch (optionInventory){
        case 1:
           System.out.println("You selected Add product");
        
           break;
        case 2:
           System.out.println("You selected Delete product");
        
           break;
        case 3:
           System.out.println("You selected Add category");
        
           break;
        case 4:
           System.out.println("You selected Delete category");
        
           break;
        case 5:
           System.out.println("You selected See stock");
        
           break;
        case 6:
           System.out.println("You selected Edit product");
        
           break;
        case 7:
           System.out.println("You selected Edit stock");
        
           break;
        case 8:
           System.out.println("You selected Edit category");
        
           break;
        case 9:
           System.out.println("thank you, we hope to see you soon");
        
           break;
    }
  } while (optionInventory!= 9);
}


 private static int obtainOptionInventory(){
        while(true){
            try {
                 int input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= 9) {
                    return input;
                } else {
                    System.out.print("Invalid option, try again: ");
                }
            } catch (NumberFormatException e){
                System.out.print("Invalid entry, try again: ");     
            }
        
        }
    
    }
}
