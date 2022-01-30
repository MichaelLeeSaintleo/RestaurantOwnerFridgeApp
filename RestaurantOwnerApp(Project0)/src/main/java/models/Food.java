package models;
/*
CREATE TABLE food(
food_id SERIAL PRIMARY KEY,
food_item varchar(50) NOT NULL,
fridge_id_fk int REFERENCES fridges(fridge_id)
);
 */

//This models will look similar to the food table.
public class Food {
    //These are my variable fields for Food.
    private Integer foodId;
    private String foodItem;
    private Integer fridgeIdFk;

    public Food(){ //No argument constructor
    }

    //The constructor
    public Food(Integer foodId, String foodItem, Integer fridgeIdFk) {
        this.foodId = foodId;
        this.foodItem = foodItem;
        this.fridgeIdFk = fridgeIdFk;
    }

    //The getters and setters

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public Integer getFridgeIdFk() {
        return fridgeIdFk;
    }

    public void setFridgeIdFk(Integer fridgeIdFk) {
        this.fridgeIdFk = fridgeIdFk;
    }

    @Override
    public String toString() {
        return "Food{" +
                "foodId=" + foodId +
                ", foodItem='" + foodItem + '\'' +
                ", fridgeIdFk=" + fridgeIdFk +
                '}' +'\n';
    }
}



