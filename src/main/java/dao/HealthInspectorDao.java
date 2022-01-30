package dao;

import models.Fridges;
import models.HealthInspector;
import java.util.List;

public interface HealthInspectorDao {

    List<HealthInspector> getAllHealthInspector();
    //Boolean addHealthInspector (HealthInspector healthInspector);

    boolean getHealthInspector(String userN, String passW);

    HealthInspector addHealthInspector(String nameH, String userH, String passH);

    Boolean deleteAssignedFood(int foodId,int fridIdFk); //Delete a food item from a fridge

    List<Integer> viewAssignedFridge(Integer hInspectorId);
}
