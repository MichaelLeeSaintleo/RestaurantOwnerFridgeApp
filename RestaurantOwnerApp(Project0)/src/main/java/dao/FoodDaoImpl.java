package dao;

import models.Food;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Fridges;

public class FoodDaoImpl implements FoodDao {
    //requires the jdbc:postgresql:// endpoint /(db name)
    String url = "jdbc:postgresql://revaturedatabase.cvrm06ri9ylv.us-east-2.rds.amazonaws.com/project0_db";
    String username = "postgres";
    String password = "p4ssw0rd";

    @Override
    public List<Food> getAllFood() {
        List<Food> food = new ArrayList<>();//This is essentially what going to return.
        //Used a try catch method to hold the list of food.
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            //sql statement that is used to be executed.
            String sql = "SELECT * FROM food;";
            //Use a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);
            //use the sql statement and return the result set.
            ResultSet rs = ps.executeQuery();
            //loop through all food that is in the result set, involving looping.
            //loop through all the records in the result set.
            while (rs.next()) {
                food.add( //Begin the instantiation of food
                        new Food(rs.getInt(1), rs.getString(2), rs.getInt(3))

                );
            }
            System.out.print(food.size());
            //Close the connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return all the data that is in the collection.
        return food;
    }

    @Override
    public Boolean addFood(String foodName, Integer fIdFk) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO food VALUES (DEFAULT, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //use the sql statement and return the result set
            ps.setString(1, foodName); // refers to the food_item index 2
            ps.setInt(2, fIdFk); // refers to the fridgeIdFk index 3
             if (ps.executeUpdate() != 0){
                 return true;
             }
            //String rs = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteFood(String foodItem, int fridIdFk) {
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            String sql = "DELETE FROM food WHERE food_item = ? AND fridge_id_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, foodItem);
            ps.setInt(2, fridIdFk);
            return ps.executeUpdate() != 0;

            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean transferFood(Integer fridgeIdFk, String fName){
        //Figure out where to put this transferFood
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            String sql = "UPDATE food SET fridge_id_fk = ? WHERE food_item = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            //Write down the prepared statements
            ps.setInt(1, fridgeIdFk);
            ps.setString(2, fName);
            return ps.executeUpdate() !=0;
             //Try and return true if it comes along
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return false;
    }

    @Override
    public List<Food> searchSpecificFridge(Integer fridId) {
        List<Food> food = new ArrayList<>();//This is essentially what going to return.
        //Used a try catch method to search a specific fridge of food.
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            //sql statement that is used to be executed.
            String sql = "SELECT * FROM food WHERE fridge_id_fk = ?;";
            //Use a prepared statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, fridId);
            //use the sql statement and return the result set.
            ResultSet rs = ps.executeQuery();
            //loop through all food that is in the result set, involving looping.
            //loop through all the records in the result set.
            while (rs.next()) {
                food.add( //Begin the instantiation of food
                        new Food(rs.getInt(1), rs.getString(2), rs.getInt(3))

                );
            }
            System.out.print(food.size());
            //Close the connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return food;
    }
}





