package ua.pt.restapi.models;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherTest {
    
    private Weather wd;
    private List<WeatherData> wdd;
    
    public WeatherTest() {
    }
    
    
    @BeforeEach
    public void setUp() {
        wdd = Arrays.asList(new WeatherData("No information", "Sem informação", 0), new WeatherData("Clear sky", "Céu limpo", 1));
        wd = new Weather("IPMA", "PT", wdd);
    }
    
    @AfterEach
    public void tearDown() {
        wd = null;
        wdd = null;
    }

    /**
     * Test of getOwner method, of class Weather.
     */
    @Test
    public void testGetOwner() {
        String expResult = "IPMA";
        String result = wd.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountry method, of class Weather.
     */
    @Test
    public void testGetCountry() {
        String expResult = "PT";
        String result = wd.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class Weather.
     */
    @Test
    public void testGetData() {
        List<WeatherData> expResult = wdd;
        List<WeatherData> result = wd.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Weather.
     */
    @Test
    public void testSetId() {
        long id = 34L;
        wd.setId(id);
        assertEquals(id, wd.getId());
    }

    /**
     * Test of setOwner method, of class Weather.
     */
    @Test
    public void testSetOwner() {
        String owner = "LMOA";
        wd.setOwner(owner);
        assertEquals(owner, wd.getOwner());
    }

    /**
     * Test of setCountry method, of class Weather.
     */
    @Test
    public void testSetCountry() {
        String country = "ES";
        wd.setCountry(country);
        assertEquals(country, wd.getCountry());
    }

    /**
     * Test of setData method, of class Weather.
     */
    @Test
    public void testSetData() {
        List<WeatherData> data = wdd;
        wd.setData(data);
        assertEquals(data, wd.getData());
    }
    
}
