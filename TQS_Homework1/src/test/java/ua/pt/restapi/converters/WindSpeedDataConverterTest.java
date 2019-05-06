package ua.pt.restapi.converters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.models.WindSpeedData;

/**
 *
 * @author Ricardo Querido
 */
public class WindSpeedDataConverterTest {

    private final WindSpeedDataConverter converter;
    private final WindSpeedData data;

    public WindSpeedDataConverterTest() {
        converter = new WindSpeedDataConverter();
        data = new WindSpeedData("Very Strong", "Muito Forte", "4");
        data.setId(0);
    }

    @Test
    public void convertFromWSToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"descClassWindSpeedDailyEN\":\"Very Strong\",\"descClassWindSpeedDailyPT\":\"Muito Forte\",\"classWindSpeed\":\"4\"}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }

    @Test
    public void convertFromStringToWS() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"descClassWindSpeedDailyEN\":\"Very Strong\",\"descClassWindSpeedDailyPT\":\"Muito Forte\",\"classWindSpeed\":\"4\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getClassWindSpeed(), data.getClassWindSpeed());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescClassWindSpeedDailyEN(), data.getDescClassWindSpeedDailyEN());
        assertEquals(converter.convertToEntityAttribute(to_convert).getDescClassWindSpeedDailyPT(), data.getDescClassWindSpeedDailyPT());
    }
}
