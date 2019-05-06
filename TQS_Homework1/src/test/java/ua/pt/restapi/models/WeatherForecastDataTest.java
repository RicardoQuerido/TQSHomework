package ua.pt.restapi.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherForecastDataTest {
    
    WeatherForecastData ss;
    
    public WeatherForecastDataTest() {
    }
    
    @BeforeEach
    public void setUp() {
        ss = new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8");
    }
    
    @AfterEach
    public void tearDown() {
        ss=null;
    }

    /**
     * Test of getPrecipitaProb method, of class WeatherForecastData.
     */
    @Test
    public void testGetPrecipitaProb() {
        String expResult = "0.0";
        String result = ss.getPrecipitaProb();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPredWindDir method, of class WeatherForecastData.
     */
    @Test
    public void testGetPredWindDir() {
        String expResult = "N";
        String result = ss.getPredWindDir();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdWeatherType method, of class WeatherForecastData.
     */
    @Test
    public void testGetIdWeatherType() {
        int expResult = 2;
        int result = ss.getIdWeatherType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getClassWindSpeed method, of class WeatherForecastData.
     */
    @Test
    public void testGetClassWindSpeed() {
        int expResult = 2;
        int result = ss.getClassWindSpeed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongitude method, of class WeatherForecastData.
     */
    @Test 
    public void testGetLongitude() {
        String expResult = "-9.1";
        String result = ss.getLongitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of getForecastDate method, of class WeatherForecastData.
     */
    @Test
    public void testGetForecastDate() {
        String expResult = "2018-01-26";
        String result = ss.getForecastDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatitude method, of class WeatherForecastData.
     */
    @Test
    public void testGetLatitude() {
        String expResult = "38.8";
        String result = ss.getLatitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTempMin method, of class WeatherForecastData.
     */
    @Test
    public void testGetTempMin() {
        String expResult = "7.6";
        String result = ss.gettMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTempMax method, of class WeatherForecastData.
     */
    @Test
    public void testGetTempMax() {
        String expResult = "13.3";
        String result = ss.gettMax();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WeatherForecastData.
     */
    @Test
    public void testSetId() {
        long id = 34L;
        ss.setId(id);
        assertEquals(id, ss.getId());
    }

    /**
     * Test of setPrecipitaProb method, of class WeatherForecastData.
     */
    @Test
    public void testSetPrecipitaProb() {
        String precipitaProb = "5.0";
        ss.setPrecipitaProb(precipitaProb);
        assertEquals(precipitaProb, ss.getPrecipitaProb());
    }

    /**
     * Test of setPredWindDir method, of class WeatherForecastData.
     */
    @Test
    public void testSetPredWindDir() {
        String predWindDir = "E";
        ss.setPredWindDir(predWindDir);
        assertEquals(predWindDir, ss.getPredWindDir());
    }

    /**
     * Test of setIdWeatherType method, of class WeatherForecastData.
     */
    @Test
    public void testSetIdWeatherType() {
        int idWeatherType = 0;
        ss.setIdWeatherType(idWeatherType);
        assertEquals(idWeatherType, ss.getIdWeatherType());
    }

    /**
     * Test of setClassWindSpeed method, of class WeatherForecastData.
     */
    @Test
    public void testSetClassWindSpeed() {
        int classWindSpeed = 0;
        ss.setClassWindSpeed(classWindSpeed);
        assertEquals(classWindSpeed, ss.getClassWindSpeed());
    }

    /**
     * Test of setLongitude method, of class WeatherForecastData.
     */
    @Test
    public void testSetLongitude() {
        String longitude = "40.34";
        ss.setLongitude(longitude);
        assertEquals(longitude, ss.getLongitude());
    }

    /**
     * Test of setForecastDate method, of class WeatherForecastData.
     */
    @Test
    public void testSetForecastDate() {
        String forecastDate = "2018-01-22";
        ss.setForecastDate(forecastDate);
        assertEquals(forecastDate, ss.getForecastDate());
    }

    /**
     * Test of setLatitude method, of class WeatherForecastData.
     */
    @Test
    public void testSetLatitude() {
        String latitude = "40.43";
        ss.setLatitude(latitude);
        assertEquals(latitude, ss.getLatitude());
    }

    /**
     * Test of setTempMin method, of class WeatherForecastData.
     */
    @Test
    public void testSetTempMin() {
        String tempMin = "4";
        ss.settMin(tempMin);
        assertEquals(tempMin, ss.gettMin());
    }

    /**
     * Test of setTempMax method, of class WeatherForecastData.
     */
    @Test
    public void testSetTempMax() {
        String tempMax = "14";
        ss.settMax(tempMax);
        assertEquals(tempMax, ss.gettMax());
    }

    
}
