package ua.pt.restapi.models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherForecastTest {

    WeatherForecast wf;
    List<WeatherForecastData> data;
    Date dt;

    public WeatherForecastTest() {
    }

    @BeforeEach
    public void setUp() {
        dt = new Date();
        data = Arrays.asList(new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"), new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"));
        wf = new WeatherForecast("IPMA", "PT", data, 1110600, "2018-01-26T09:02:03", dt);
    }

    @AfterEach
    public void tearDown() {
        wf = null;
    }

    /**
     * Test of getOwner method, of class WeatherForecast.
     */
    @Test
    public void testGetOwner() {
        String expResult = "IPMA";
        String result = wf.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountry method, of class WeatherForecast.
     */
    @Test
    public void testGetCountry() {
        String expResult = "PT";
        String result = wf.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGlobalIdLocal method, of class WeatherForecast.
     */
    @Test
    public void testGetGlobalIdLocal() {
        int expResult = 1110600;
        int result = wf.getGlobalIdLocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDataUpdate method, of class WeatherForecast.
     */
    @Test
    public void testGetDataUpdate() {
        String expResult = "2018-01-26T09:02:03";
        String result = wf.getDataUpdate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastRefresh method, of class WeatherForecast.
     */
    @Test
    public void testGetLastRefresh() {
        Date expResult = dt;
        Date result = wf.getLastRefresh();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class WeatherForecast.
     */
    @Test
    public void testGetData() {
        List<WeatherForecastData> expResult = data;
        List<WeatherForecastData> result = wf.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WeatherForecast.
     */
    @Test
    public void testSetId() {
        long id = 34L;
        wf.setId(id);
        assertEquals(id, wf.getId());
    }

    /**
     * Test of setOwner method, of class WeatherForecast.
     */
    @Test
    public void testSetOwner() {
        String owner = "LIVID";
        wf.setOwner(owner);
        assertEquals(owner, wf.getOwner());
    }

    /**
     * Test of setCountry method, of class WeatherForecast.
     */
    @Test
    public void testSetCountry() {
        String country = "ES";
        wf.setCountry(country);
        assertEquals(country, wf.getCountry());
    }

    /**
     * Test of setGlobalIdLocal method, of class WeatherForecast.
     */
    @Test
    public void testSetGlobalIdLocal() {
        int globalIdLocal = 1003003;
        wf.setGlobalIdLocal(globalIdLocal);
        assertEquals(globalIdLocal, wf.getGlobalIdLocal());
    }

    /**
     * Test of setDataUpdate method, of class WeatherForecast.
     */
    @Test
    public void testSetDataUpdate() {
        String dataUpdate = "lmoa";
        wf.setDataUpdate(dataUpdate);
        assertEquals(dataUpdate, wf.getDataUpdate());
    }

    /**
     * Test of setLastRefresh method, of class WeatherForecast.
     */
    @Test
    public void testSetLastRefresh() {
        Date lastRefresh = dt;
        wf.setLastRefresh(lastRefresh);
        assertEquals(lastRefresh, wf.getLastRefresh());
    }

    /**
     * Test of setData method, of class WeatherForecast.
     */
    @Test
    public void testSetData() {
        List<WeatherForecastData> da = data;
        wf.setData(da);
        assertEquals(da, wf.getData());
    }

}
