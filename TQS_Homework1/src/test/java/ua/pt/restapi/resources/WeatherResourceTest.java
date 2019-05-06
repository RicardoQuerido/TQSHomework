package ua.pt.restapi.resources;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ua.pt.restapi.dao.WeatherDAO;
import ua.pt.restapi.models.CacheStats;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.DistrictData;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherData;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WeatherForecastData;
import ua.pt.restapi.models.WindSpeed;
import ua.pt.restapi.models.WindSpeedData;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherResourceTest {

    WeatherAPI instance;

    public WeatherResourceTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new WeatherAPI();
        instance.weatherDAO = mock(WeatherDAO.class);

    }

    @AfterEach
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getWindSpeed method, of class WeatherResource.
     */
    @Test
    public void testGetWindSpeed() {
        List<WindSpeedData> wsd = Arrays.asList(new WindSpeedData("Weak", "Fraco", "1"), new WindSpeedData("Moderate", "Moderado", "2"));
        WindSpeed ws = new WindSpeed("IPMA", "PT", wsd);
        Response expResult = Response.ok(ws).build();
        when(instance.weatherDAO.getWindSpeed()).thenReturn(ws);
        Response result = instance.getWindSpeed();

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getAllDistrict method, of class WeatherResource.
     */
    @Test
    public void testGetAllDistrict() {
        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"),
                new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
                new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        District dt = new District("IPMA", "Portugal", data);

        Response expResult = Response.ok(dt).build();
        when(instance.weatherDAO.getDistricts()).thenReturn(dt);
        Response result = instance.getAllDistrict();

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getWeatherForecast method, of class WeatherResource.
     */
    @Test
    public void testGetWeatherForecast() {
        Date dt = new Date();
        List<WeatherForecastData> data = Arrays.asList(new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"), new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"));
        WeatherForecast wf = new WeatherForecast("IPMA", "PT", data, 1110600, "2018-01-26T09:02:03", dt);

        Response expResult = Response.ok(wf).build();
        when(instance.weatherDAO.getWeatherForecastByDistrict(instance.weatherDAO.translateDistrict("Lisboa"))).thenReturn(wf);
        Response result = instance.getWeatherForecast("Lisboa");

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getAllWeather method, of class WeatherResource.
     */
    @Test
    public void testGetAllWeather() {
        List<WeatherData> wdd = Arrays.asList(new WeatherData("No information", "Sem informação", 0), new WeatherData("Clear sky", "Céu limpo", 1));
        Weather wd = new Weather("IPMA", "PT", wdd);

        Response expResult = Response.ok(wd).build();
        when(instance.weatherDAO.getWeather()).thenReturn(wd);
        Response result = instance.getAllWeather();

        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getCacheStats method, of class WeatherResource.
     */
    @Test
    public void testGetCacheStats() {
        CacheStats wd = new CacheStats(0, 0, 0);

        Response expResult = Response.ok(wd).build();
        when(instance.weatherDAO.getCacheStats()).thenReturn(wd);
        Response result = instance.getCacheStats();

        assertEquals(expResult.toString(), result.toString());
    }
    
}
