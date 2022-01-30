package dao;

import models.Fridges;

import java.util.List;

public interface FridgesDao {
    List<Fridges> getAllFridges();
    Boolean addFridges(Integer restIdFk);
    Boolean deleteFridges(Integer id, Integer idFk ); //I added a fridge_id_fk to be more specific.

}
