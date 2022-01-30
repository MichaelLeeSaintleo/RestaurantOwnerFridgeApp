package dao;

import models.Fridges;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
By Michael Lee
 */

public class FridgesDaoImpl implements FridgesDao{
    String url = "jdbc:postgresql://revaturedatabase.cvrm06ri9ylv.us-east-2.rds.amazonaws.com/project0_db";
    String username = "postgres";
    String password = "p4ssw0rd";
    private Object Fridges;

    @Override
    public List<Fridges> getAllFridges() {
        List<Fridges> fridges = new ArrayList<>();//return an ArrayList
        //Used a try catch method to hold the list of fridges.
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            //sql statement that is used to be executed.
            String sql = "SELECT * FROM fridges;";
            PreparedStatement ps = conn.prepareStatement(sql);//Prepared Statement
            ResultSet rs = ps.executeQuery();//use the sql statement and return the result set.
            while (rs.next()) { //loop through all the fridges and records in the result set.
                fridges.add( //Begin the instantiation of fridges
                        new Fridges(rs.getInt(1), rs.getInt(2))

                );
            }
            //Close the connection
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Return all the data that is in the collection.
        return fridges;
    }

    @Override
    public Boolean addFridges(Integer restIdFk) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            //Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO fridges VALUES (DEFAULT, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //use the sql statement and return the result set
            ps.setInt(1, restIdFk); // refers to the fridgeIdFk index 3

            //conn.close(); //Make sure to close the connection before the return
            return ps.executeUpdate() !=0;
            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Boolean deleteFridges(Integer id, Integer idFk) {
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            String sql = "DELETE FROM fridges WHERE fridge_id = ? AND restaurant_id_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, idFk);
            //ResultSet rs = ps.executeQuery(); //For deleting a Fridge, we are using DML (ps.executeUpdate).
            return ps.executeUpdate() !=0;

            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
