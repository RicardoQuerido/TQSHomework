package ua.pt.restapi.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherDataTest {
    
    private WeatherData ff;

    
    public WeatherDataTest() {
    }
    
    @BeforeEach
    public void setUp() {
        ff = new WeatherData("No information", "Sem informação", 0);
    }
    
    @AfterEach
    public void tearDown() {
        ff=null;
    }

    /**
     * Test of getDescIdWeatherTypeEN method, of class WeatherData.
     */
    @Test
    public void testGetDescIdWeatherTypeEN() {
        String expResult = "No information";
        String result = ff.getDescIdWeatherTypeEN();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdWeatherType method, of class WeatherData.
     */
    @Test
    public void testGetIdWeatherType() {
        int expResult = 0;
        int result = ff.getIdWeatherType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescIdWeatherTypePT method, of class WeatherData.
     */
    @Test
    public void testGetDescIdWeatherTypePT() {
        String expResult = "Sem informação";
        String result = ff.getDescIdWeatherTypePT();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WeatherData.
     */
    @Test
    public void testSetId() {
        long id = 0L;
        ff.setId(id);
        assertEquals(id, ff.getId());
    }

    /**
     * Test of setDescIdWeatherTypeEN method, of class WeatherData.
     */
    @Test
    public void testSetDescIdWeatherTypeEN() {
        String descIdWeatherTypeEN = "LMOA";
        ff.setDescIdWeatherTypeEN(descIdWeatherTypeEN);
        assertEquals(descIdWeatherTypeEN, ff.getDescIdWeatherTypeEN());
    }

    /**
     * Test of setDescIdWeatherTypePT method, of class WeatherData.
     */
    @Test
    public void testSetDescIdWeatherTypePT() {
        String descIdWeatherTypePT = "LMOA";
        ff.setDescIdWeatherTypePT(descIdWeatherTypePT);
        assertEquals(descIdWeatherTypePT, ff.getDescIdWeatherTypePT());
    }

    /**
     * Test of setIdWeatherType method, of class WeatherData.
     */
    @Test
    public void testSetIdWeatherType() {
        int idWeatherType = 2;
        ff.setIdWeatherType(idWeatherType);
        assertEquals(idWeatherType, ff.getIdWeatherType());
    }
    
}
