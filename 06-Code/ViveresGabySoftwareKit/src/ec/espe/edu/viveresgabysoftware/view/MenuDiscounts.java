package ec.espe.edu.viveresgabysoftware.view;

import java.util.Scanner;

/**
 *
 * @author Stefany Díaz
 */
public class MenuDiscounts{
    private Scanner scanner;
    
    public MenuDiscounts(){
        scanner = new Scanner(System.in);
    }
    
    public void handMenuDiscounts(){
        int option;
        do{
            System.out.println("----Menu----");
            System.out.println("1. Create Discount");
            System.out.println("2. Delete Discount");
            System.out.println("3. Salir");
            System.out.print("Choose an option and press enter: ");
            option = getOption();
            
            switch(option){
                 case 1:
                    System.out.println("You selected Create Discount");
                    doCreateDiscountAction();
                    break;
                case 2:
                    System.out.println("You selected Delete Discount");
                    doDeleteDiscountAction();
                    break;
                case 3:
                    System.out.println("Leaving the program...");
                    break;
                default:
                    System.out.println("Try again, invalid option");
            }
        }while(option !=3);
    
    }
    
    private int getOption(){
        while(true){
            char input = scanner.next().charAt(0);
            
            switch(input){
                case 'W':
                case 'w':
                    return 1; // Up
                case 'S':
                case 's':
                    return 2; // Down
                case 'A':
                case 'a':
                    return 3; // Left
                case 'D':
                case 'd':
                    return 4; // Right
                case '\n':
                    return 0; // Enter
                default:
                    System.out.println("Try again, invalid key ");
            }
        
        }
    }
    
    private void doCreateDiscountAction(){
        System.out.println("doBiilsAction");
    }
    
    private void doDeleteDiscountAction(){
        System.out.println("doClientAction");
    }
    
}
