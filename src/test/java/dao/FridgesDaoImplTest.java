package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FridgesDaoImplTest {

    FridgesDao fridgeDao;

    @BeforeEach
    void setup() { fridgeDao = new FridgesDaoImpl(); }

    @Test
    void addFridges() {

        //Assign
        Boolean expectedResult = true;

        //Act
        Boolean actualResult = fridgeDao.addFridges(1);

        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void deleteFridges() {

        //Assign
        Boolean expectedResult = true;

        //Act
        Boolean actualResult = fridgeDao.deleteFridges(21, 1);

        //Assert
        assertEquals(expectedResult, actualResult);
    }
}