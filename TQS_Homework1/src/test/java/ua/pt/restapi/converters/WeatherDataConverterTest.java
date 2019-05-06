package ua.pt.restapi.converters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.models.WeatherData;

/**
 *
 * @author Ricardo Querido
 */
public class WeatherDataConverterTest {

    private final WeatherDataConverter converter;
    private final WeatherData data;

    public WeatherDataConverterTest() {
        converter = new WeatherDataConverter();
        data = new WeatherData("Partly cloudy", "Céu pouco nublado", 2);
        data.setId(0);
    }

    @Test
    public void convertFromWToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"descIdWeatherTypeEN\":\"Partly cloudy\",\"descIdWeatherTypePT\":\"Céu pouco nublado\",\"idWeatherType\":2}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToW() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"descIdWeatherTypeEN\":\"Partly cloudy\",\"descIdWeatherTypePT\":\"Céu pouco nublado\",\"idWeatherType\":2}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdWeatherType(), data.getIdWeatherType());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescIdWeatherTypeEN(), data.getDescIdWeatherTypeEN());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescIdWeatherTypePT(), data.getDescIdWeatherTypePT());
    }

}
