package service;

import dao.FoodDao;
import dao.FridgesDao;
import dao.FoodDaoImpl;
import dao.FridgesDaoImpl;
import models.Food;
import models.Fridges;

import java.util.List;

public class FridgesService {

    /*
    * List<Fridges> getAllFridges();
    void addFridges(Fridges fridges);
    Boolean deleteFridges(int fridge_id);
    * */

    private static FridgesDao fridgesDao;

    public FridgesService() { this.fridgesDao = new FridgesDaoImpl(); }
    public List<Fridges> getAllFridges() {return this.fridgesDao.getAllFridges();}
    FoodDao foodDao = new FoodDaoImpl();

    //AddFridge
    public void addFridge (Integer restIdFk){
        List<Fridges> fridges = fridgesDao.getAllFridges();
        System.out.println(fridges.size());// I am not sure if this is needed, but I will try.
       if(this.fridgesDao.addFridges(restIdFk)) {
            System.out.println("New fridge has been created.");
       }
       else
           System.out.println("New fridge could not be created.");
    }

    //DeleteFridge
    public void deleteAFridge(Integer id, Integer idFk){ //if it is an array list, it is size.
        List<Fridges> fridges = fridgesDao.getAllFridges();
        System.out.println(fridges.size());  //counting the number of fridges
        if(fridges.size() > 1){//create an if statement for have at least one fridge.
            if(foodDao.searchSpecificFridge(id).size() > 0) {//If there is food in fridge
                System.out.println("WARNING: YOU HAVE FOOD IN THIS FRIDGE!");
                return;
            }
            if(this.fridgesDao.deleteFridges(id, idFk)) {
                System.out.println("fridge id has been deleted.");
            }
            else
                System.out.println("fridge id cannot be found.");
            }
        }

        /*if(this.fridgesDao.deleteFridges(id, idFk)) {
            System.out.println("fridge id " + id + " has been deleted.");
        }
        else
            System.out.println("fridge id " + id + " cannot be found.");
        }*/
    }


