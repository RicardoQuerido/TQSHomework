package ua.pt.restapi.converters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.models.WeatherForecastData;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherForecastDataConverterTest {

    private final WeatherForecastDataConverter converter;
    private final WeatherForecastData data;

    public WeatherForecastDataConverterTest() {
        converter = new WeatherForecastDataConverter();
        data = new WeatherForecastData("0.0", "7.6", "13.3", "N", 2, 2, "-9.1", "2018-01-26", "38.8");
        data.setId(0);
    }

    @Test
    public void convertFromWSToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"precipitaProb\":\"0.0\",\"tMin\":\"7.6\",\"tMax\":\"13.3\",\"predWindDir\":\"N\",\"idWeatherType\":2,\"classWindSpeed\":2,\"longitude\":\"-9.1\",\"forecastDate\":\"2018-01-26\",\"latitude\":\"38.8\"}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToWS() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"precipitaProb\":\"0.0\",\"tMin\":\"7.6\",\"tMax\":\"13.3\",\"predWindDir\":\"N\",\"idWeatherType\":2,\"classWindSpeed\":2,\"longitude\":\"-9.1\",\"forecastDate\":\"2018-01-26\",\"latitude\":\"38.8\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getClassWindSpeed(), data.getClassWindSpeed());
        assertEquals(converter.convertToEntityAttribute(to_convert).getForecastDate(), data.getForecastDate());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdWeatherType(), data.getIdWeatherType());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLongitude(), data.getLongitude());
        assertEquals(converter.convertToEntityAttribute(to_convert).getPrecipitaProb(), data.getPrecipitaProb());
        assertEquals(converter.convertToEntityAttribute(to_convert).getPredWindDir(), data.getPredWindDir());
        assertEquals(converter.convertToEntityAttribute(to_convert).gettMax(), data.gettMax());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLatitude(), data.getLatitude());
        assertEquals(converter.convertToEntityAttribute(to_convert).gettMin(), data.gettMin());

    }

}
