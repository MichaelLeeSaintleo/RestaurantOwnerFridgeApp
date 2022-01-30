package dao;

import models.Food;
import models.Fridges;
import java.util.List;

//The data access object for Food
//SQL script
public interface FoodDao {
    //All I need are a few operations (addFood, deleteFood )
    //It is important to declare the functionality for dao
    List<Food> getAllFood(); //Get the Food List items
    Boolean addFood(String foodName, Integer fIdFk); //Food item and fridge_id_fk
    Boolean deleteFood(String foodItem,int fridIdFk); //Delete a food
    Boolean transferFood(Integer fridgeIdFk, String fName);//Transfer a food item to a fridge
    List<Food> searchSpecificFridge(Integer fridId); //Creating a List of food, using Integer Id.

}
