package dao;

import models.Restaurant;

import java.util.List;

public interface RestaurantDao {

    // void removeFridge(Integer fridge_id);

    List<Restaurant> getAllRestaurant();

    boolean getRestaurantAccount (String user, String pass);

    Restaurant addRestaurant(String nameRA, String nameRU, String passR);
    //Restaurant getRestaurant(String username);

    Boolean assignFridgeToHealth(Integer inspectId, Integer refridgeId);


}
