package ec.edu.espe.viveresgabysoftwarekit.model;
import java.util.Scanner;

/**
 *
 * @author Stefany Díaz
 */
public class MenuDiscounts{
    
    private static Scanner scanner = new Scanner(System.in);
    int option;
    public void handMenuDiscounts(){
        do{
            System.out.println("----Discounts Menu----");
            System.out.println("1. History");
            System.out.println("2. Create Discount");
            System.out.println("3. Delete Discount");
            System.out.println("4. Return to principal menu");
            System.out.print("Choose an option: ");
            
        option = getOption();

            switch(option){
                 case 1:
                    System.out.println("You selected History");
                    doHistoryAction();
                    break;
                    
                case 2:
                    System.out.println("You selected Create Discount");
                    doCreateDiscountAction();
                    break;
                    
                case 3:
                    System.out.println("You selected Delete Discount");
                    doDeleteDiscountAction();
                    break;
                    
                case 4:
                    System.out.println("Leaving to the principal menu...");
                    break;
                            
                default:
                    System.out.println("Try again, invalid option");
            }
        }while(option !=4);

    }

    private static int getOption(){
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
    
    private void doHistoryAction(){
        System.out.println("Discounts History");
        System.out.println("---- Discounts History Menu ----");
        System.out.println("1. View History");
        System.out.println("2. Add Discount");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
    }
}
    

    private void doCreateDiscountAction(){
        System.out.println("Discount - Create");
    }

    private void doDeleteDiscountAction(){
        System.out.println("Discount Delete");
        System.out.println("---- Delete Discount Menu ----");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }
    }
}
    
