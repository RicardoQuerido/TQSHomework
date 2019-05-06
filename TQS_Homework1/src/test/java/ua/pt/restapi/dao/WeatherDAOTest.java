package ua.pt.restapi.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.pt.restapi.models.CacheStats;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.DistrictData;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherData;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WeatherForecastData;
import ua.pt.restapi.models.WindSpeed;
import ua.pt.restapi.models.WindSpeedData;
import ua.pt.restapi.service.WeatherService;

/**
 *
 * @author Ricardo Querido
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(WeatherService.class)
public class WeatherDAOTest {

    private WeatherDAO weatherDAO;
    private TypedQuery mockQuery;

    private WeatherService service;

    public WeatherDAOTest() {
    }



    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        weatherDAO = spy(WeatherDAO.class);
        service = spy(WeatherService.class);
        weatherDAO.em = mock(EntityManager.class);
        weatherDAO.service = service;

        mockQuery = mock(TypedQuery.class);
        when(weatherDAO.em.createNamedQuery(anyString(), any())).thenReturn(mockQuery);
    }

    @AfterEach
    public void tearDown() {
        weatherDAO = null;
    }

    /**
     * Test of getWeather method, of class WeatherDAO, when there're cache.
     */
    @Test
    public void testGetWeatherWithCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        List<WeatherData> wdd = Arrays.asList(new WeatherData("No information", "Sem informação", 0), new WeatherData("Clear sky", "Céu limpo", 1));
        Weather wd = new Weather("IPMA", "PT", wdd);
        weatherDAO.createWeather(wd);

        List<Weather> w = new ArrayList<>();
        w.add(wd);

        when(weatherDAO.em.createNamedQuery("Weather.findAll", Weather.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        Weather expResult = wd;
        Weather result = weatherDAO.getWeather();
        assertEquals(expResult, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfHits());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getWeather method, of class WeatherDAO, when there aren't cache.
     */
    @Test
    public void testGetWeatherWithoutCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        List<WeatherData> wdd = Arrays.asList(new WeatherData("No information", "Sem informação", 0), new WeatherData("Clear sky", "Céu limpo", 1));
        Weather wd = new Weather("IPMA", "PT", wdd);

        doReturn(wd).when(service).consumeWeather();

        List<Weather> w = new ArrayList<>();

        when(weatherDAO.em.createNamedQuery("Weather.findAll", Weather.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        //when(WeatherService.consumeWeather()).thenReturn(wd);
        Weather result = weatherDAO.getWeather();
        assertEquals(wd, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfMisses());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of findWeatherById method, of class WeatherDAO.
     */
    @Test
    public void testFindWeatherById() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();
        List<WeatherData> wdd = Arrays.asList(new WeatherData("No information", "Sem informação", 0), new WeatherData("Clear sky", "Céu limpo", 1));
        Weather wd = new Weather("IPMA", "PT", wdd);
        weatherDAO.createWeather(wd);
        List<Weather> w = new ArrayList<>();
        w.add(wd);

        when(weatherDAO.em.createNamedQuery("Weather.findAll", Weather.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        WeatherData result = weatherDAO.findWeatherById(0);
        assertEquals(wdd.get(0), result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
    }

    /**
     * Test of getWindSpeed method, of class WeatherDAO.
     */
    @Test
    public void testGetWindSpeedWithCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        //when(weatherDAO.getCacheStats()).thenReturn(new CacheStats(0,0,0));
        List<WindSpeedData> wdd = Arrays.asList(new WindSpeedData("No information",
                "Sem informação", "0"), new WindSpeedData("Clear sky", "Céu limpo", "1"));
        WindSpeed wd = new WindSpeed("IPMA", "PT", wdd);
        weatherDAO.createWindSpeed(wd);

        List<WindSpeed> w = new ArrayList<>();
        w.add(wd);

        when(weatherDAO.em.createNamedQuery("WindSpeed.findAll", WindSpeed.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        WindSpeed expResult = wd;
        WindSpeed result = weatherDAO.getWindSpeed();
        assertEquals(expResult, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfHits());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getWeather method, of class WeatherDAO.
     */
    @Test
    public void testGetWindSpeedWithoutCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        List<WindSpeedData> wdd = Arrays.asList(new WindSpeedData("No information", "Sem informação", "0"), new WindSpeedData("Clear sky", "Céu limpo", "1"));
        WindSpeed wd = new WindSpeed("IPMA", "PT", wdd);

        doReturn(wd).when(service).consumeWindSpeed();

        List<WindSpeed> w = new ArrayList<>();

        when(weatherDAO.em.createNamedQuery("WindSpeed.findAll", WindSpeed.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        WindSpeed result = weatherDAO.getWindSpeed();
        assertEquals(wd, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfMisses());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of findWindSpeedById method, of class WeatherDAO.
     */
    @Test
    public void testFindWindSpeedById() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();
        List<WindSpeedData> wdd = Arrays.asList(new WindSpeedData("No information", "Sem informação", "0"), new WindSpeedData("Clear sky", "Céu limpo", "1"));
        WindSpeed wd = new WindSpeed("IPMA", "PT", wdd);
        weatherDAO.createWindSpeed(wd);
        List<WindSpeed> w = new ArrayList<>();
        w.add(wd);

        when(weatherDAO.em.createNamedQuery("WindSpeed.findAll", WindSpeed.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        WindSpeedData result = weatherDAO.findWindSpeedById("0");
        assertEquals(wdd.get(0), result);

        CacheStats cacheStats = weatherDAO.getCacheStats();

    }


    /**
     * Test of getAllWeatherForecast method, of class WeatherDAO.
     *
     * @Test public void testGetAllWeatherForecast() throws Exception {
     * .println("getAllWeatherForecast"); EJBContainer container =
     * javax.ejb.embeddable.EJBContainer.createEJBContainer(); WeatherDAO
     * instance = (WeatherDAO)
     * container.getContext().lookup("java:global/classes/WeatherDAO"); List
     * expResult = null; List result = instance.getAllWeatherForecast();
     * assertEquals(expResult, result); container.close(); // TODO review the
     * generated test code and remove the default call to fail. fail("The test
     * case is a prototype."); }
     */

    /**
     * Test of getWeatherForecastByDistrict method, of class WeatherDAO, when
     * there aren't cache.
     */
    @Test
    public void testGetWeatherForecastByDistrictWithoutCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        Date dt = new Date();
        List<WeatherForecastData> data = Arrays.asList(new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"), new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"));
        WeatherForecast wf = new WeatherForecast("IPMA", "PT", data, 1110600, "2018-01-26T09:02:03", dt);

        doReturn(wf).when(service).consumeWeatherForecast("1110600");

        List<WeatherForecast> w = new ArrayList<>();

        when(weatherDAO.em.createNamedQuery("WeatherForecast.findAll", WeatherForecast.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        //when(WeatherService.consumeWeather()).thenReturn(wd);
        WeatherForecast result = weatherDAO.getWeatherForecastByDistrict("1110600");
        assertEquals(wf, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfMisses());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getWeatherForecastByDistrict method, of class WeatherDAO, with
     * cache, but without the info asked
     */
    @Test
    public void testGetWeatherForecastByDistrictWithCacheWithoutValue() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        //when(weatherDAO.getCacheStats()).thenReturn(new CacheStats(0,0,0));
        Date dt = new Date();
        List<WeatherForecastData> data = Arrays.asList(new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"), new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"));
        WeatherForecast wf = new WeatherForecast("IPMA", "PT", data, 1110600, "2018-01-26T09:02:03", dt);
        WeatherForecast wf1 = new WeatherForecast("IPMA", "PT", data, 1110601, "2018-01-26T09:02:03", dt);
        weatherDAO.createWeatherForecast(wf);
        weatherDAO.createWeatherForecast(wf1);

        List<WeatherForecast> w = new ArrayList<>();
        w.add(wf);

        when(weatherDAO.getAllWeatherForecast()).thenReturn(w);
        doReturn(wf1).when(service).consumeWeatherForecast("1110601");

        WeatherForecast expResult = wf1;
        WeatherForecast result = weatherDAO.getWeatherForecastByDistrict("1110601");
        assertEquals(expResult, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfMisses());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getWeatherForecastByDistrict method, of class WeatherDAO, with
     * cache, but with the info asked
     */
    @Test
    public void testGetWeatherForecastByDistrictWithCacheWithValue() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        Date dt = new Date();
        List<WeatherForecastData> data = Arrays.asList(new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"), new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8"));
        WeatherForecast wf = new WeatherForecast("IPMA", "PT", data, 1110600, "2018-01-26T09:02:03", dt);
        weatherDAO.createWeatherForecast(wf);

        List<WeatherForecast> w = new ArrayList<>();
        w.add(wf);

        when(weatherDAO.getAllWeatherForecast()).thenReturn(w);

        WeatherForecast expResult = wf;
        WeatherForecast result = weatherDAO.getWeatherForecastByDistrict("1110600");
        assertEquals(expResult, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfHits());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getDistricts method, of class WeatherDAO.
     */
    @Test
    public void testGetDistrictsWithCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"), new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
                new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        District dt = new District("IPMA", "Portugal", data);
        weatherDAO.createDistrict(dt);

        List<District> w = new ArrayList<>();
        w.add(dt);

        when(weatherDAO.em.createNamedQuery("District.findAll", District.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        District expResult = dt;
        District result = weatherDAO.getDistricts();
        assertEquals(expResult, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfHits());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of getWeather method, of class WeatherDAO.
     */
    @Test
    public void testGetDistrictsWithoutCache() throws Exception {
        doReturn(new CacheStats(0, 0, 0)).when(weatherDAO).getCacheStats();

        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"), new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
                new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        District dt = new District("IPMA", "Portugal", data);

        doReturn(dt).when(service).consumeDistrict();

        List<WindSpeed> w = new ArrayList<>();

        when(weatherDAO.em.createNamedQuery("District.findAll", District.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        District result = weatherDAO.getDistricts();
        assertEquals(dt, result);

        CacheStats cacheStats = weatherDAO.getCacheStats();
        assertEquals(1, cacheStats.getNumberOfMisses());
        assertEquals(1, cacheStats.getNumberOfRequests());
    }

    /**
     * Test of translateDistrict method, of class WeatherDAO.
     */
    @Test
    public void testTranslateDistrict() throws Exception {

        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"),
                new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
                new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        District dt = new District("IPMA", "Portugal", data);
        doReturn(dt).when(weatherDAO).getDistricts();

        String id = weatherDAO.translateDistrict("Beja");
        int expectedResult = 1020500;
        assertEquals(id, expectedResult + "");
    }

    /**
     * Test of findDistrictById method, of class WeatherDAO.
     */
    @Test
    public void testFindDistrictById() throws Exception {

        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"),
                new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
                new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        District dt = new District("IPMA", "Portugal", data);
        List<District> w = new ArrayList<>();
        w.add(dt);

        when(weatherDAO.em.createNamedQuery("District.findAll", District.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(w);

        DistrictData result = weatherDAO.findDistrictById(Long.parseLong(2 + ""));
        assertEquals(data.get(0), result);
    }


    /**
     * Test of getCacheStats method, of class WeatherDAO.
     */
    @Test
    public void testGetCacheStatsWithCache() throws Exception {
        CacheStats data = new CacheStats(0, 0, 0);
        List<CacheStats> list = Arrays.asList(data);
        weatherDAO.createCacheStats(data);

        when(weatherDAO.em.createNamedQuery("CacheStats.find", CacheStats.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(list);

        CacheStats expResult = data;
        CacheStats result = weatherDAO.getCacheStats();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCacheStats method, of class WeatherDAO.
     */
    @Test
    public void testGetCacheStatsWithoutCache() throws Exception {
        List<CacheStats> list = new ArrayList<>();

        when(weatherDAO.em.createNamedQuery("CacheStats.find", CacheStats.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(list);

        CacheStats expResult = new CacheStats(0, 0, 0);
        CacheStats result = weatherDAO.getCacheStats();
        assertEquals(expResult.getNumberOfRequests(), result.getNumberOfRequests());

    }

    /**
     * Test of findCacheStats method, of class WeatherDAO.
     */
    @Test
    public void testFindCacheStats() throws Exception {
        CacheStats cache = new CacheStats(0, 0, 0);
        List<CacheStats> list = Arrays.asList(cache);

        when(weatherDAO.em.createNamedQuery("CacheStats.find", CacheStats.class)).thenReturn(mockQuery);
        when(mockQuery.getResultList()).thenReturn(list);

        CacheStats result = weatherDAO.findCacheStats(cache.getId());
        assertEquals(cache, result);
    }
}
