package models;

/*
CREATE TABLE restaurant(
restaurant_id SERIAL PRIMARY KEY,
restaurant_name (varchar)(50) NOT NULL,
restaurant_username varchar(50) NOT NULL,
restaurant_password varchar(50) NOT NULL
);
 */

public class Restaurant {
    //These are my variable fields for Restaurant
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantUserName;
    private String restaurantPassword;

    public Restaurant() {
    }

    public Restaurant(Integer restaurantId, String restaurantName, String restaurantUserName, String restaurantPassword) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantUserName = restaurantUserName;
        this.restaurantPassword = restaurantPassword;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantUserName() {
        return restaurantUserName;
    }

    public void setRestaurantUserName(String restaurantUserName) {
        this.restaurantUserName = restaurantUserName;
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantUserName='" + restaurantUserName + '\'' +
                ", restaurantPassword='" + restaurantPassword + '\'' +
                '}' +'\n';
    }
}
