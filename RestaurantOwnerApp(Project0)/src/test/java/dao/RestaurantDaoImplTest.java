package dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantDaoImplTest {

    RestaurantDao restaurantDao;

    @BeforeEach
    void setup() { restaurantDao = new RestaurantDaoImpl();}

    @Test
    void assignFridgeToHealth() {//This is for my Inspector Id and refridgeratorId
        //Assign
        Boolean expectedResult = true;

        //Act
        Boolean actualResult = restaurantDao.assignFridgeToHealth(8,16);

        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void getRestaurantAccount() {
        //Assign
        Boolean expectedResult = true;

        //Act
        Boolean actualResult = restaurantDao.getRestaurantAccount("ChrisLee","password" );

        //Assert
        assertEquals(expectedResult,actualResult);
    }
}