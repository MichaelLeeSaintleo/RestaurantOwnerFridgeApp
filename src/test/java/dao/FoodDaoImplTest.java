package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodDaoImplTest {

    FoodDao foodDao;

    @BeforeEach
    void setup() { foodDao = new FoodDaoImpl();}

    @Test
    void addFood() {
        //Assign
        Boolean expectedResult = true;

        //Act
        Boolean actualResult = foodDao.addFood("pie", 5);

        //Assert
        assertEquals(expectedResult,actualResult);
    }
}