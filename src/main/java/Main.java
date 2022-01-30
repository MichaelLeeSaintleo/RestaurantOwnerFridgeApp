import dao.*;
import menu.views.MainMenuView;
import models.Food;
import models.Restaurant;
import service.FoodService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // For user input, a Scanner will be used to be instantiated
        //Scanner scanner = new Scanner(System.in);

        /*
        Use the display option for the menu views to connect with the user.
        The MainMenuView.display(); will begin the project.
        */
        MainMenuView.display();

        //When the main program ends, the following message will show.
        System.out.println("Thank you for your time and take care!");


        //Here is where the service package is being called.
        /*FoodService foodService = new FoodService();
        HealthInspectorService healthInspectorService = new HealthInspectorService();
        RestaurantService restaurantService = new RestaurantService();
        FridgesService fridgesService = new FridgesService();
*/

        //you cannot instantiate an interface
       /* FoodDao foodDao = new FoodDaoImpl();
        FridgesDao fridgesDao = new FridgesDaoImpl();
        RestaurantDao restaurantDao = new RestaurantDaoImpl();
        HealthInspectorDao healthInspectorDao = new HealthInspectorDaoImpl();*/
//

        //Food food = new Food();
        //Fridges fridges = new Fridges();
        //Restaurant restaurant = new Restaurant();
        //HealthInspector inspector = new HealthInspector();


// These are the commands to make sure that the dao is connected to the database.
        //food.setFoodItem("pizza");
        //food.setFridgeIdFk(3);
        //foodDao.addFood(ribs);

        //System.out.println(foodDao.getAllFood());
        //System.out.println(restaurantDao.getAllRestaurant());

        //System.out.println(healthInspectorDao.getAllHealthInspector());
        //System.out.println(fridgesDao.getAllFridges());

        //foodDao.deleteFood(6);

        //System.out.println(foodDao.addFood());
        //System.out.println(foodDao.deleteFood());


        //foodDao.addFood("ribs", 16);


        //restaurantDao.addRestaurant(new Restaurant(null, "Sam's Bakery", "SamBakery", "password"));


        //healthInspectorDao.addHealthInspector(new HealthInspector(null, "Chloe", "ChloeInvestigator", "investigator"));
        //foodDao.addFood(new Food(null, "pepperoni pizza", 2 ));
        //fridgesDao.addFridges(new Fridges(null, 3));

    }
}
