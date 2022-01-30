package menu.views;

import service.RestaurantService;

import java.util.Scanner;

public class RestaurantSignUpView {
    public static void display() {
        //We need to loop the following
        RestaurantService restaurantService = new RestaurantService();
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        //Remember to make changes Michael!! Make this look like building a Restaurant Account!!
        while(running){
            //Here, we can display a menu
            System.out.println("\n-----------------------------------------------------------------");
            System.out.println("\n----- This is the Registration for a Restaurant Account-----");
            System.out.println("\n In order to sign up, please type the following:");
            System.out.println("1) Enter a Restaurant Name, Username, & Password:");
            System.out.println("0) Go Back");
            System.out.println("Press a number:");

            //receive input from the user.
            Integer result = scanner.nextInt();

            switch (result){
                case 1:
                    scanner.nextLine();
                    System.out.println("Restaurant Name:");
                    String nameRA = scanner.nextLine(); //Write the username:
                    System.out.println("Restaurant Username:");
                    String nameRU = scanner.nextLine();
                    System.out.println("Restaurant Password:");
                    String passR = scanner.nextLine();
                    restaurantService.addRestaurantAcc(nameRA, nameRU, passR);
                    //Add the right link information
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
