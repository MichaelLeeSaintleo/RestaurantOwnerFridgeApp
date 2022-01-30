package menu.views;

import service.FoodService;
import service.HealthInspectorService;

import java.util.Scanner;

public class HealthInspectorAccountView {
    public static void display() {
        HealthInspectorService healthInspectorService = new HealthInspectorService();
        FoodService foodService = new FoodService();
        //loop the following
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        //need to display a menu
        while(running) {
            //receive input form the user
            System.out.println("---------------------------------------------------------------");
            System.out.println("-------Welcome back Health Inspector!-------");
            System.out.println("1) View a given Fridge");
            System.out.println("2) Remove a food item in a fridge");
            System.out.println("0) Logout");
            System.out.println("---------------------------------------------------------------");

            //receive the input from the user
            String result = scanner.nextLine();

            switch (result) {
                case "1": //view the given permission of the fridge.
                    System.out.println("To view a given fridge, please enter your Health Inspector Id:");
                    Integer hInspectorId = scanner.nextInt();
                    healthInspectorService.viewInspectorFridge(hInspectorId);
                    break;
                case "2": //remove (delete) a food item from a fridge. //NEED TO TEST THIS!!!!!!
                    System.out.println("Please enter the Fridge Id for that Food Name:");
                    int fridIdFk = scanner.nextInt();
                    System.out.println("----------------------This is the list of Food Items--------------------- ");
                    System.out.println(foodService.getAllFoodItems());
                    System.out.println("Please enter the Food Id you want to delete:");
                    int foodId = scanner.nextInt(); //Must call the Food Name.
                    scanner.nextLine();
                    healthInspectorService.deleteFoodItem(foodId, fridIdFk); //Parameters, type the variable names.
                    System.out.println(foodService.getAllFoodItems());
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("This is an Invalid Input for the Health Inspector Account.");
            }
        }
    }
}
