package models;

/*
CREATE TABLE fridges(
fridge_id SERIAL PRIMARY KEY,
restaurant_id_fk int REFERENCES restaurant(restaurant_id),
);
 */

public class Fridges {
    //These are my variable fields for Fridges
    private Integer fridgeId;
    private Integer restaurantOwnerIdFk;

    public Fridges(){ //no argument constructor
    }
    //The constructor
    public Fridges(Integer fridgeId, Integer restaurantOwnerIdFk) {
        this.fridgeId = fridgeId;
        this.restaurantOwnerIdFk = restaurantOwnerIdFk;
    }
    //This is the getters and setters


    public Integer getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(Integer fridgeId) {
        this.fridgeId = fridgeId;
    }

    public Integer getRestaurantOwnerIdFk() {
        return restaurantOwnerIdFk;
    }

    public void setRestaurantOwnerIdFk(Integer restaurantOwnerIdFk) {
        this.restaurantOwnerIdFk = restaurantOwnerIdFk;
    }

    //Have your toString()

    @Override
    public String toString() {
        return "Fridges{" +
                "fridgeId=" + fridgeId +
                ", restaurantOwnerIdFk=" + restaurantOwnerIdFk +
                '}' + '\n';
    }
}
