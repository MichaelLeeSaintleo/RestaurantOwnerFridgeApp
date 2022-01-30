package service;

import dao.FoodDao;
import dao.FoodDaoImpl;
import models.Food;

import java.util.List;

 /*
 This Food class will provide the functionality of typical list.
 */

public class FoodService {

    private static FoodDao foodDao;

    public FoodService() {
        this.foodDao = new FoodDaoImpl();
    }

    public List<Food> getAllFoodItems() {
        return this.foodDao.getAllFood();
    }

    public Food food = new Food();

    //adding a addFood option.
    public void addFoodItem(String foodName, Integer fIdFk) {
        //When adding a food item, make sure that the limit is 5.
        //Have a foodList that
        List<Food> foodList = foodDao.searchSpecificFridge(fIdFk);
        for (int i = 0; i < foodList.size(); i++) { //gives the current foodList
            System.out.println(foodList.get(i).getFoodItem());
        } //The food list will check if a fridge holds five food items.
        if (foodList.size() > 4) {
            System.out.println("The current food item could not be added.");
            return;
        }//Modified the five items in a fridge

        if (this.foodDao.addFood(foodName, fIdFk)) {
            System.out.println("The current food item was added.");
        } else {
            System.out.println("The current food item could not be added.");
        }
    }


    //This is deleting food item option.
    public void deleteFoodItem(String foodItem, int fridIdFk) {
        if (this.foodDao.deleteFood(foodItem, fridIdFk)) {

            System.out.println("Food item: " + foodItem + " has been deleted.");
        } else
            System.out.println("Food item: " + foodItem + " could not be found.");

    }

    //This is where I will transfer food items
    public void transferFoodItem(Integer fridgeIdFk, String fName) {
        try {
            if (this.foodDao.transferFood(fridgeIdFk, fName)) {
                System.out.println("This Food item has been transferred.");
            } else
                System.out.println("This Food item could not be transferred.");

            }catch (Exception e) {
            e.printStackTrace();
        }

    }
}



