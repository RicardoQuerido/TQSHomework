package ua.pt.restapi.service;

import javax.ws.rs.client.ClientBuilder;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.pt.restapi.models.District;
import ua.pt.restapi.models.Weather;
import ua.pt.restapi.models.WeatherForecast;
import ua.pt.restapi.models.WindSpeed;

/**
 *
 * @author Ricardo Querido
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClientBuilder.class)
public class WeatherServiceTest {
    
    private WeatherService service; 
    
    public WeatherServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        service = new WeatherService();
    }
    
    @AfterEach
    public void tearDown() {
        service = null;
    }

    /**
     * Test of consumeWeatherForecast method, of class WeatherService.
     */
    @Test
    public void testConsumeWeatherForecast() throws Exception {
        String globalIdLocal = "1010500";
        WeatherForecast result = service.consumeWeatherForecast(globalIdLocal);
        assertThat(result, instanceOf(WeatherForecast.class));
    }

    /**
     * Test of consumeWindSpeed method, of class WeatherService.
     */
    @Test
    public void testConsumeWindSpeed() throws Exception {
        WindSpeed result = service.consumeWindSpeed();
        assertThat(result, instanceOf(WindSpeed.class));
    }

    /**
     * Test of consumeDistrict method, of class WeatherService.
     */
    @Test
    public void testConsumeDistrict() throws Exception {
        District result = service.consumeDistrict();
        assertThat(result, instanceOf(District.class));
    }

    /**
     * Test of consumeWeather method, of class WeatherService.
     */
    @Test
    public void testConsumeWeather() throws Exception {     
        Weather result = service.consumeWeather();
        assertThat(result, instanceOf(Weather.class));
    }
    
}
