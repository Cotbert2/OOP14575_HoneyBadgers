package ec.edu.espe.viveresgabysoftwarekit.utils;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class Validator {
    Scanner in = new Scanner(System.in);

    public int getIntOption() {
        boolean validNum = false;
        int option = 0 ;
        while (!validNum) {
            try {
                option =in.nextInt();
                validNum = true;
            } catch (InputMismatchException e) {
                System.out.print("Invalid option, try again: ");
                in.nextLine();
            }
        }
        return option;
    }

    public int getYNOption(){
        boolean validYN = false;
        int option = 0;
        while(!validYN){
            try{
                option = in.next().charAt(0);
                if(option == 'y' || option == 'Y' || option == 'n' || option == 'N'){
                    validYN = true;
                }else{
                    System.out.print("Invalid option, try again: ");
                }
            }catch(InputMismatchException e){
                System.out.print("Invalid option, try again: ");
                in.nextLine();
            }
        }
        return option;
    }
}
