package ua.pt.restapi.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WindSpeedData;

/**
 *
 * @author Ricardo Querido
 */
@Converter
public class WindSpeedDataConverter implements AttributeConverter<WindSpeedData, String>{

    @Override
    public String convertToDatabaseColumn(WindSpeedData windSpeedDataList) {
        if (windSpeedDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WindSpeedData>(){}.getType();

        return gson.toJson(windSpeedDataList, type);
    }

    @Override
    public WindSpeedData convertToEntityAttribute(String windSpeedData) {
        if (windSpeedData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WindSpeedData>(){}.getType();

        return gson.fromJson(windSpeedData, type);
    }
    
}
