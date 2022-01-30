package menu.views;

import java.util.Scanner;

public class MainMenuView {

    public static void display(){

        //We need to loop the following
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while(running){
            //Here, we can display a menu
            System.out.println("\n----- Welcome to the Restaurant Owner App!----");
            System.out.println("\n How may I help you? Please select these options:");
            System.out.println("1) Login");
            System.out.println("2) Signup for a Restaurant Account");
            System.out.println("3) Signup for a Health Inspector Account");
            System.out.println("0) Exit");
            System.out.println("Press a number:");

            //receive input from the user.
            String result = scanner.nextLine();

            switch (result){
                case "1":
                    LoginView.display();
                    break;
                case "2":
                    RestaurantSignUpView.display();
                    break;
                case "3":
                    HealthInspectorSignUpView.display();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("This is an invalid input");
            }
        }
    }
}
