package menu.views;

import service.HealthInspectorService;
import service.RestaurantService;

import java.util.Scanner;

public class LoginView {
    public static void display(){
        HealthInspectorService healthInspectorService = new HealthInspectorService();
        RestaurantService restaurantService = new RestaurantService();
        Scanner scanner = new Scanner(System.in);

        Boolean running = true;

        //receive input from the user.
        //Integer result = scanner.nextInt();

        while(running){
            //display
            System.out.println("---------------------------------------------------------");
            System.out.println("Here is the Login View");
            System.out.println("Please enter the following:");
            System.out.println("1) Enter a Restaurant Username & Password:");
            System.out.println("2) Enter a Health Inspector Username & Password:");
            System.out.println("0) Go back ");
            System.out.println("--------------------------------------------------------");


            //receive inputs from the user
            String result = scanner.nextLine();
            //do something with inputs
            switch(result){
                case "1"://Enter Restaurant Username and Password
                    System.out.println("Username:");
                    String user = scanner.nextLine();//do not use username: it connects to PostgresSQL
                    System.out.println("Password:");
                    String pass = scanner.nextLine();//d not use password: it connects to PostgreSQL
                    restaurantService.loginRestaurantAcc(user, pass);
                    break;
                case "2"://Enter Health Inspector Username and Password
                    System.out.println("Username:");
                    String userN = scanner.nextLine();//do not use username: it connects to PostgresSQL
                    System.out.println("Password:");
                    String passW = scanner.nextLine();//d not use password: it connects to PostgreSQL
                    healthInspectorService.loginHealthInspector(userN,passW);
                    break;
                case "0":
                    running = false;
                default:
                    System.out.println("This is an invalid input");
            }
        }


    }
}
