package ec.edu.espe.viveresgabysoftwarekit.model;
import java.util.Scanner;

/**
 *
 * @author Stefany Díaz
 */
public class MenuFinancer{
    private static Scanner scanner = new Scanner(System.in);
    int option;
    
    public void handMenuFinancer(){
        do{
            System.out.println("----Menu Financer----");
            System.out.println("1. Bills");
            System.out.println("2. Client");
            System.out.println("3. Financer Status");
            System.out.println("4. Update Taxes");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            
        option = getOption();

            switch(option){
                 case 1:
                    System.out.println("You selected Bills");
                    doBillsAction();
                    break;
                case 2:
                    System.out.println("You selected Client");
                    doClientAction();
                    break;
                case 3:
                    System.out.println("You selected Financer Status");
                    doFinancerStatusAction();
                    break;
                case 4:
                    System.out.println("You selected Update Taxes");
                    doUpdateTaxesAction();
                    break;
                case 5:
                    System.out.println("Leaving to the principal menu...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        }while(option !=5);

    }

    private int getOption(){
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

    private void doBillsAction(){
        int subOption;
        do{
            System.out.println("---Financer - Bill Menu---");
            System.out.println("1. Create Bill");
            System.out.println("1. History Bills");
            System.out.println("2. Delete Bill ");
            System.out.println("3. Back");
            
        subOption = getOption();
        
        switch(subOption){
            case 1:
                System.out.println("You selected Create Bill");
                break;
            case 2:
                System.out.println("You selected Delete Bill");
                break;
            case 3:
                System.out.println("Back to Menu Financer");
                break;
            case 4:
                System.out.println("Back to Menu Financer");
                break;
            default:
                System.out.println("Try again, invalid option");
        
        }
      } while(subOption !=4);
}

    private void doClientAction(){
        int subOption;
        do{
            System.out.println("---Financer - Client Menu---");
            System.out.println("1. Create Client");
            System.out.println("2. See all Clients ");
            System.out.println("3. Back");
            
        subOption = getOption();
        
        switch(subOption){
            case 1:
                System.out.println("You selected Create Client");
                break;
            case 2:
                System.out.println("You selected See all Clients");
                break;
            case 3:
                System.out.println("Back to Menu Financer");
                break;
            default:
                System.out.println("Try again, invalid option");
        
        }
      } while(subOption !=3);
}


    private void doFinancerStatusAction(){
        System.out.println("---Financer Status Menu---");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
        }   
    }
      



    private void doUpdateTaxesAction(){
        System.out.println("---Financer - Update Taxes Menu---");
        System.out.println("0. Go Back");

        int subOption = getOption();

        if (subOption == 0) {
            System.out.println("Going back to Financer Menu...");
        } else {
            System.out.println("Invalid option, try again");
    }
}    
    }


