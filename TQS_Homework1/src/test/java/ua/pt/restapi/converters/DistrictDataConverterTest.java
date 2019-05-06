package ua.pt.restapi.converters;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ua.pt.restapi.models.DistrictData;

/**
 *
 * @author Ricardo Querido
 */
public class DistrictDataConverterTest {
    
    private final DistrictDataConverter converter;
    private final DistrictData data;
    
    public DistrictDataConverterTest() {
        converter = new DistrictDataConverter();
        data = new DistrictData(1,"AVR", 5, 1010500, "40.6413", 1, "Aveiro", "-8.6535");
        data.setId(0);
    }

    @Test
    public void convertFromDToString() {
        assertNull(converter.convertToDatabaseColumn(null));

        String expected_out = "{\"id\":0,\"idRegiao\":1,\"idAreaAviso\":\"AVR\",\"idConcelho\":5,\"globalIdLocal\":1010500,\"latitude\":\"40.6413\",\"idDistrito\":1,\"local\":\"Aveiro\",\"longitude\":\"-8.6535\"}";
        assertEquals(converter.convertToDatabaseColumn(data), expected_out);
    }
    
    @Test
    public void convertFromStringToD() {
        assertNull(converter.convertToDatabaseColumn(null));

        String to_convert = "{\"id\":0,\"idRegiao\":1,\"idAreaAviso\":\"AVR\",\"idConcelho\":5,\"globalIdLocal\":1010500,\"latitude\":\"40.6413\",\"idDistrito\":1,\"local\":\"Aveiro\",\"longitude\":\"-8.6535\"}";
        assertEquals(converter.convertToEntityAttribute(to_convert).getId(), data.getId());
        assertEquals(converter.convertToEntityAttribute(to_convert).getGlobalIdLocal(), data.getGlobalIdLocal());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdAreaAviso(), data.getIdAreaAviso());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdConcelho(), data.getIdConcelho());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdDistrito(), data.getIdDistrito());
        assertEquals(converter.convertToEntityAttribute(to_convert).getIdRegiao(), data.getIdRegiao());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLatitude(), data.getLatitude());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLocal(), data.getLocal());
        assertEquals(converter.convertToEntityAttribute(to_convert).getLongitude(), data.getLongitude());
    }
    
}
