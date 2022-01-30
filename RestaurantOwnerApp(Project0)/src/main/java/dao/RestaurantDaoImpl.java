package dao;

import menu.views.RestaurantAccountView;
import models.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {
    //requires the jdbc:postgresql:// endpoint /(db name)
    String url = "jdbc:postgresql://revaturedatabase.cvrm06ri9ylv.us-east-2.rds.amazonaws.com/project0_db";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public List<Restaurant> getAllRestaurant() {
        List<Restaurant> restaurant = new ArrayList<>(); //This will return an ArrayList.
        //Use a try catch method for the restaurant list.
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM restaurant;";//sql statement to be executed.
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); //This will return the result set.
            //Use the while loop for all restaurants and records in the result set.
            while (rs.next()) {//Make sure to ask your batch mates about the while loop.
                restaurant.add( //Have the instantiation process for restaurant.
                        new Restaurant(rs.getInt(1), rs.getString(2),
                                rs.getString(2), rs.getString(2))
                );
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return the data to the collection.
        return restaurant;
    }

    @Override
    public Restaurant addRestaurant(String nameRA, String nameRU, String passR) {
        boolean restaurantAccComplete = false;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO restaurant VALUES (DEFAULT, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            //use the sql statement and return the result set
            ps.setString(1, nameRA); // parameter index 1 is the second column
            ps.setString(2, nameRU); // parameter index 2 is the third column
            ps.setString(3, passR);
            ps.executeUpdate(); //execute the updates

            /*//If you want to find a specific restaurant account
            String str = "SELECT * from restaurant WHERE restaurant_id = ?;";
            PreparedStatement pps = conn.prepareStatement(str);
            pps.setInt(1, restaurant.getRestaurantId());
            ResultSet set = pps.executeQuery();
            if(set.next())
                restaurant.setRestaurantId(set.getInt(1));
            conn.close();
             */

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Restaurant(); //Return a new Restaurant Object
    }

    @Override
    public Boolean assignFridgeToHealth(Integer inspectId, Integer refridgeId) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO health_inspector_fridges_ck VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            //use the sql statement and return the result set
            ps.setInt(1, inspectId); // parameter index 1 is the second column
            ps.setInt(2, refridgeId); // parameter index 2 is the third column
            return ps.executeUpdate() != 0; //execute the updates
            //return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean getRestaurantAccount(String user, String pass) {
        boolean restaurantAccComplete = false;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM restaurant WHERE restaurant_username = ? AND restaurant_password = ?;";//sql statement to be executed.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery(); //This will return the result set.
            if (rs.next()) {
                //RestaurantAccountView.display();//If true, got to RestaurantAccountView
                restaurantAccComplete = true;
                //System.out.println("Checkpoint");//This will indicate if the restaurant is true
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurantAccComplete;
    }
}



