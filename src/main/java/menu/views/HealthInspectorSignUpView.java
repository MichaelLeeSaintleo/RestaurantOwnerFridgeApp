package menu.views;

import service.HealthInspectorService;
import service.RestaurantService;

import java.util.Scanner;

public class HealthInspectorSignUpView {
    public static void display(){
        //We need to loop the following
        HealthInspectorService healthInspectorService = new HealthInspectorService();
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        //Remember to make changes Michael!! Make this look like building a Restaurant Account!!
        while(running){
            //Here, we can display a menu
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("\n----- This is the Health Inspector Registration-----");
            System.out.println("\n In order to sign up, please type the following:");
            System.out.println("1) Enter a Health Inspector Name, Username, & Password:");
            System.out.println("0) Go Back");
            System.out.println("Press a number:");

            //receive input from the user.
            Integer result = scanner.nextInt();

            //Using a switch statement
            switch (result){
                case 1://Add the right link information
                    scanner.nextLine();
                    System.out.println("Health Inspector Name:"); //Write your name:
                    String nameH = scanner.nextLine();
                    System.out.println("Health Inspector Username:"); //Write your username:
                    String userH = scanner.nextLine();
                    System.out.println("Health Inspector Password:"); //Write your password:
                    String passH = scanner.nextLine();
                    healthInspectorService.addHealthAcc(nameH, userH, passH);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("This is an invalid input");
            }
        }
    }
}
