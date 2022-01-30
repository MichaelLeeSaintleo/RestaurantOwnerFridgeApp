package service;

import dao.RestaurantDao;
import dao.RestaurantDaoImpl;
import menu.views.RestaurantAccountView;
import models.Restaurant;

import java.util.ArrayList;
import java.util.List;



public class RestaurantService {

    /*
        This class will be used to perform the list functionality.

        List<Restaurant> getAllRestaurant();
        void addRestaurant(Restaurant restaurant);
     */

    RestaurantAccountView restaurantAccountView= new RestaurantAccountView();
    //Initialize restaurantDao
    private RestaurantDao restaurantDao;
    public RestaurantService(){ this.restaurantDao = new RestaurantDaoImpl();}
    public List<Restaurant> getAllRestaurantAcc() {return this.restaurantDao.getAllRestaurant();}

    //include an add Restaurant option
    public void addRestaurantAcc(String nameRA, String nameRU, String passR) {
        RestaurantDao restaurantDao = new RestaurantDaoImpl();
        if(restaurantDao.addRestaurant(nameRA, nameRU, passR) != null)
            System.out.println(" Restaurant Account has been created");
        else
            System.out.println(" Restaurant Account was not added.  Unfortunately, there is an error.");

    }

    //Include a login Restaurant option
    public boolean loginRestaurantAcc (String user, String pass) {
        //RestaurantDao restaurantDao = new RestaurantDaoImpl(); //call in instant of restaurantDao.
        if(this.restaurantDao.getRestaurantAccount(user, pass)){
            System.out.println("Restaurant Login is successful.");
            restaurantAccountView.display();
        }else
            System.out.println("The login has failed.");
        return false;
    }

    //Here is where a Restaurant Owner can assign a fridge to a health inspector.
    public boolean assignFridge (Integer inspectId, Integer refridgeId) {
        if(this.restaurantDao.assignFridgeToHealth(inspectId, refridgeId)){
            System.out.println("The Fridge has been assigned.");
        }else
            System.out.println("Error: the Fridge could not be assigned.");
        return false;
    }

}
