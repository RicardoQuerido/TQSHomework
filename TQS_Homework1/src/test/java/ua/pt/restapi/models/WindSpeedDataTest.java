package ua.pt.restapi.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class WindSpeedDataTest {
    
    private WindSpeedData wsd;
    
    public WindSpeedDataTest() {
    }
    
    @BeforeEach
    public void setUp() {
        wsd = new WindSpeedData("Weak", "Fraco", "1");
    }
    
    @AfterEach
    public void tearDown() {
        wsd = null;
    }

    /**
     * Test of getDescClassWindSpeedDailyEN method, of class WindSpeedData.
     */
    @Test
    public void testGetDescClassWindSpeedDailyEN() {
        String expResult = "Weak";
        String result = wsd.getDescClassWindSpeedDailyEN();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescClassWindSpeedDailyPT method, of class WindSpeedData.
     */
    @Test
    public void testGetDescClassWindSpeedDailyPT() {
        String expResult = "Fraco";
        String result = wsd.getDescClassWindSpeedDailyPT();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClassWindSpeed method, of class WindSpeedData.
     */
    @Test
    public void testGetClassWindSpeed() {
        String expResult = "1";
        String result = wsd.getClassWindSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WindSpeedData.
     */
    @Test
    public void testSetId() {
        long id = 34L;
        wsd.setId(id);
        assertEquals(id, wsd.getId());
    }

    /**
     * Test of setDescClassWindSpeedDailyEN method, of class WindSpeedData.
     */
    @Test
    public void testSetDescClassWindSpeedDailyEN() {
        String descClassWindSpeedDailyEN = "Moderate";
        wsd.setDescClassWindSpeedDailyEN(descClassWindSpeedDailyEN);
        assertEquals(descClassWindSpeedDailyEN, wsd.getDescClassWindSpeedDailyEN());
    }

    /**
     * Test of setDescClassWindSpeedDailyPT method, of class WindSpeedData.
     */
    @Test
    public void testSetDescClassWindSpeedDailyPT() {
        String descClassWindSpeedDailyPT = "Moderado";
        wsd.setDescClassWindSpeedDailyPT(descClassWindSpeedDailyPT);
        assertEquals(descClassWindSpeedDailyPT, wsd.getDescClassWindSpeedDailyPT());
    }

    /**
     * Test of setClassWindSpeed method, of class WindSpeedData.
     */
    @Test
    public void testSetClassWindSpeed() {
        String classWindSpeed = "2";
        wsd.setClassWindSpeed(classWindSpeed);
        assertEquals(classWindSpeed, wsd.getClassWindSpeed());
    }
    
}
