package ec.espe.edu.viveresgabysoftware.view;

import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Stefany Díaz
 */
public class MenuFinancer{
    private Scanner scanner;
    
    public MenuFinancer(){
        scanner = new Scanner(System.in);
    }
    
    public void handMenuFinancer(){
        int option;
        do{
            System.out.println("----Menu----");
            System.out.println("1. Bills");
            System.out.println("2. Client");
            System.out.println("3. Financer Status");
            System.out.println("4. Update Taxes");
            System.out.println("5. Salir");
            System.out.print("Choose an option and press enter: ");
            option = getOption();
            
            switch(option){
                 case 1:
                    System.out.println("You selected Bills");
                    doBiilsAction();
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
                    System.out.println("Leaving the program...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        }while(option !=5);
    
    }
    
    private int getOption(){
        int option = 0;
        boolean validKey = false;
        
        while(!validKey){
            char input = scanner.next().charAt(0);
            
            switch(input){
                case KeyEvent.VK_UP:
                    option = 1; // Up
                    validKey = true;
                    break;
                case KeyEvent.VK_DOWN:
                    option = 2; // Down
                    validKey = true;
                    break;
                case KeyEvent.VK_LEFT:
                    option = 3; // Left
                    validKey = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    option = 4; // Right
                    validKey = true;
                    break;
                case KeyEvent.VK_ENTER:
                    option = 0; // Enter
                    validKey = true;
                    break;
                default:
                    System.out.println("Try again, invalid key ");
            }
        
        }
        return option;
    }
    
    private void doBiilsAction(){
        System.out.println("doBiilsAction");
    }
    
    private void doClientAction(){
        System.out.println("doClientAction");
    }
    
    private void doFinancerStatusAction(){
        System.out.println("doFinancerStatusAction");
    }
    
    private void doUpdateTaxesAction(){
        System.out.println("doUpdateTaxesAction");
    }   
}
