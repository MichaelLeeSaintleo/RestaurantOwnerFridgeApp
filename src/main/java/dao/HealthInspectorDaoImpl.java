package dao;

import menu.views.HealthInspectorAccountView;
import models.Fridges;
import models.HealthInspector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HealthInspectorDaoImpl implements HealthInspectorDao {
    String url = "jdbc:postgresql://revaturedatabase.cvrm06ri9ylv.us-east-2.rds.amazonaws.com/project0_db";
    String username = "postgres";
    String password = "p4ssw0rd";


    @Override
    public List<HealthInspector> getAllHealthInspector() {
        List<HealthInspector> healthInspectors = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM health_inspector;";//sql statement to be executed.
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); //This will return the result set.
            while (rs.next()) {
                healthInspectors.add(
                        new HealthInspector(rs.getInt(1), rs.getString(2),
                                rs.getString(3), rs.getString(4))
                );
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthInspectors;
    }
    //I had trouble getting this dao implementation to work.
    /*@Override
    public Boolean addHealthInspector(HealthInspector healthInspector) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO health_inspector VALUES (DEFAULT, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //use the sql statement and return the result set
            ps.setString(1, healthInspector.getInspectorName()); // parameter index 1 is the second column
            ps.setString(2, healthInspector.getInspectorUserName()); // parameter index 2 is the third column
            ps.setString(3, healthInspector.getInspectorPassword()); // parameter index 3 is the fourth column
            ps.executeUpdate();

           *//* //I am wondering if I need this to find a specific inspector using an inspector_id.
            String str = "SELECT * FROM health_inspector WHERE inspector_id = ?;";
            PreparedStatement pps = conn.prepareStatement(str);
            pps.setInt(1, healthInspector.getInspectorId());
            ResultSet set = pps.executeQuery();
            if (set.next())healthInspector.setInspectorId(set.getInt(1));
            conn.close();*//*

        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }*/

    @Override
    public boolean getHealthInspector(String userN, String passW) {
        //HealthInspector healthInspector = new HealthInspector(); //returning to the model HealthInspector
        boolean healthAccComplete = false;
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM health_inspector WHERE inspector_username = ? AND inspector_password = ?;"; //sql statement to be executed.
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userN);
            ps.setString(2, passW);
            ResultSet rs = ps.executeQuery(); //This will return the result set.
            if (rs.next()) {
                HealthInspectorAccountView.display();//If true, go to HealthInspectorAccountView
                healthAccComplete = true;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthAccComplete;
    }

    //I am using this for my alternative to add a Health Inspector
    @Override
    public HealthInspector addHealthInspector(String nameH, String userH, String passH) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO health_inspector VALUES (DEFAULT, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            //use the sql statement and return the result set
            ps.setString(1, nameH); // parameter index 1 is the second column
            ps.setString(2, userH); // parameter index 2 is the third column
            ps.setString(3, passH); // parameter index 3 is the fourth column
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new HealthInspector();
    }

    //Add a Delete function for a Health Inspector to delete food inside a fridge.
    @Override
    public Boolean deleteAssignedFood(int foodId, int fridIdFk) {
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            String sql = "DELETE FROM food WHERE food_id = ? AND fridge_id_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, foodId);
            ps.setInt(2, fridIdFk);
            return ps.executeUpdate() != 0;

            //conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override //This is where the Health Inspector can view a given fridge
    public List<Integer> viewAssignedFridge(Integer hInspectorId) {
        List<Integer> assignedFridgeId = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);) {
            String sql = "SELECT * FROM health_inspector_fridges_ck WHERE inspector_id_fk = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, hInspectorId);
            //return ps.executeQuery() != 0;
            ResultSet rs = ps.executeQuery(); //This will return the result set.
            /*if (rs.next()) {
                HealthInspectorAccountView.display();//If true, go to HealthInspectorAccountView

            }*/

            while (rs.next()) {
                assignedFridgeId.add(rs.getInt(2));
                conn.close();}

                //conn.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
            return assignedFridgeId;

    }
}



