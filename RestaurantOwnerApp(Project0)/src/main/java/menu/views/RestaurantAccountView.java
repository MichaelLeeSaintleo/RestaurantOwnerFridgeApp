package menu.views;
import models.Restaurant;
import dao.RestaurantDao;
import dao.HealthInspectorDaoImpl;
import service.FoodService;
import service.FridgesService;
import service.HealthInspectorService;
import service.RestaurantService;

import java.util.Scanner;
import java.util.List;

public class RestaurantAccountView {
    public static void display() {
        RestaurantService restaurantService = new RestaurantService();
        FridgesService fridgesService = new FridgesService();
        FoodService foodService = new FoodService();
        HealthInspectorService healthInspectorService = new HealthInspectorService();

        //loop the following
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;
        //need to display a menu
        while(running) {
            //receive input form the user
            System.out.println("---------------------------------------------------------------");
            System.out.println("-------Welcome back Restaurant Owner!-------");
            System.out.println("1) View all Fridge(s)"); //Change this to where a restaurant owner can view their own fridge using their id.
            System.out.println("2) Add a Fridge");
            System.out.println("3) Delete a Fridge");
            System.out.println("4) Deposit (Add) Food into a Fridge");
            System.out.println("5) Withdraw (Delete) food from Fridge");
            System.out.println("6) Transfer (Move) Food to a Fridge");
            System.out.println("7) Assign a Fridge to a HealthInspector(s)");
            System.out.println("0) Logout");

            //receive the input from the user
            String result = scanner.nextLine();

            switch (result){
                case "1": //Case 1 will activate the current list of fridges.
                    System.out.println("-----------This is a List of Current Fridges-----------");
                    System.out.println(fridgesService.getAllFridges());
                    break;
                case "2": //Case 2 will add a Fridge.
                    System.out.println("Please enter your Restaurant ID (restaurant_id_fk):");
                    Integer restIdFk = scanner.nextInt();
                    fridgesService.addFridge(restIdFk);
                    System.out.println(fridgesService.getAllFridges());
                    break;
                case "3":
                    System.out.println("-----------------Here are the Current Lists-----------------");
                    System.out.println(fridgesService.getAllFridges());
                    System.out.println("Please enter the Fridge Id:");
                    Integer id = scanner.nextInt(); //place the Fridge Id
                    scanner.nextLine();
                    System.out.println("Please enter the Restaurant Id:");
                    Integer idFk = scanner.nextInt();
                    fridgesService.deleteAFridge(id, idFk);
                    System.out.println(fridgesService.getAllFridges());
                    break;
                case "4"://Deposit (Add) food to a fridge ///THIS NEEDS TO BE FIXED!!!!!!
                    System.out.println("Please enter a Food Name:");
                    String foodName = scanner.nextLine(); //Enter a Food name (foodName).
                    System.out.println("Please enter the Fridge Id you want the food to be placed:");
                    int fIdFk = scanner.nextInt(); //place of the fridge Id (fridge_id_fk).
                    foodService.addFoodItem(foodName, fIdFk);
                    System.out.println(foodService.getAllFoodItems());//look and see all the current food items.
                    //foodService.transferFoodItem();
                    break;
                case "5": //Withdraw (Delete) Food
                    System.out.println("---------------Here is a List of Current Food Items ------------------");
                    System.out.println(foodService.getAllFoodItems());
                    System.out.println("Please enter the Food Name:");
                    String foodItem = scanner.nextLine();//calling the Food Name.
                    System.out.println("Please enter the Fridge Id that holds the Food Item:"); //needs to be fixed.
                    int fridIdFk = scanner.nextInt();
                    //scanner.nextLine(); //do not need a scanner.nextLine();
                    foodService.deleteFoodItem(foodItem, fridIdFk);//in parameters, type deleteId.
                    System.out.println(foodService.getAllFoodItems());
                    break;
                case "6"://Transfer food from one fridge to fridge
                    System.out.println(foodService.getAllFoodItems());
                    System.out.println("Please enter the Fridge id you want to select:");
                    Integer fridgeIdFk = scanner.nextInt();
                    scanner.nextLine(); // Does not read the new line creating input
                    System.out.println("Please enter the Food Item you want to take:");
                    String fName = scanner.nextLine();
                    //scanner.nextLine(); //do not need this, because it will add another line.
                    foodService.transferFoodItem(fridgeIdFk, fName);
                    System.out.println(foodService.getAllFoodItems());
                    //foodService.transferFoodItem();
                    break;
                case "7": //Assign a Fridge to a HealthInspector(s). //Need to test this!!!
                    System.out.println("________________Here are the Current Fridges_____________________");
                    System.out.println(fridgesService.getAllFridges()); //display all fridges
                    System.out.println("To assign a fridge, please insert the Fridge Id:");
                    Integer refridgeId = scanner.nextInt(); //connect the restaurant service integer (inspectorId)
                    System.out.println("________________Here is a list of the current Health Inspectors_________________");
                    System.out.println(healthInspectorService.viewAllHealthInspector());
                    //System.out.println(healthInspectorService.);
                    System.out.println("Please type the Health Inspector Id:");
                    Integer inspectId = scanner.nextInt(); //connect to the restaurant service integer (refridgeId)
                    restaurantService.assignFridge(inspectId, refridgeId);
                    //System.out.println(fridgesService.getAllFridges());
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("This is an Invalid Input for the Restaurant Account.");
            }
        }



    }
}
