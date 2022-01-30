package service;

import models.Fridges;
import models.HealthInspector;
import dao.HealthInspectorDao;
import dao.HealthInspectorDaoImpl;
import models.Restaurant;

import java.util.List;


public class HealthInspectorService {
    //Need to use a public initializer
    private HealthInspectorDao healthInspectorDao;

    public HealthInspectorService() {
        this.healthInspectorDao = new HealthInspectorDaoImpl();
    }

    public List<HealthInspector> viewAllHealthInspector() {
        return this.healthInspectorDao.getAllHealthInspector();
    }

    //
    //include an add HealthInspector option
    public void addHealthAcc(String nameH, String userH, String passH) {
        HealthInspectorDao healthInspectorDao = new HealthInspectorDaoImpl();
        //List<HealthInspector> HealthList = healthInspectorDao.getAllHealthInspector(); //Added a Private variable on line 14. Do not need this.
        if (this.healthInspectorDao.addHealthInspector(nameH, userH, passH) != null) //question if I should put the "this".
            System.out.println("The Health Inspector Account has been created.");
        else
            System.out.println("The Health Inspector Account was not added.  Unfortunately, there is an error.");
    }

    //include a login HealthInspector option
    public void loginHealthInspector(String userN, String passW) { //do not use username and password, it will connect to postgreSQL.
        //HealthInspectorDao healthInspectorDao = new HealthInspectorDaoImpl(); //call an instant of healthInspectorDao.
        if (this.healthInspectorDao.getHealthInspector(userN, passW)) {
            System.out.println(" Health Inspector Login is successful. Welcome Back!");
        } else
            System.out.println("The login has failed.");
    }

    //This is deleting food item option.
    public void deleteFoodItem(int foodId, int fridIdFk) {
        System.out.println(foodId + fridIdFk); //Verify the variables
        if (this.healthInspectorDao.deleteAssignedFood(foodId, fridIdFk)) {

            System.out.println("The Food item has been deleted.");
        } else
            System.out.println("The Food item could not be found.");
    }

    //The Health Inspector should view the assigned Fridge made by the Restaurant Owner
    public void viewInspectorFridge(Integer hInspectorId) {
        //This is service needs to be connected to DAO
        //to get Fridges ID, we must call the Integer hInspectorId
        System.out.println("This is list of the assigned Fridges:");
        System.out.println(healthInspectorDao.viewAssignedFridge(hInspectorId));

        /*if (this.healthInspectorDao.viewAssignedFridge(hInspectorId)) {

            System.out.println( hInspectorId + " has been granted access. ");
        } else
            System.out.println( hInspectorId + " could not be found.");
        //return false;*/
    }

}
