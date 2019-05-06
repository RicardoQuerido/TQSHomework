package ua.pt.restapi.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WeatherData;

/**
 *
 * @author Ricardo Querido
 */
@Converter
public class WeatherDataConverter implements AttributeConverter<WeatherData, String> {

    @Override
    public String convertToDatabaseColumn(WeatherData weatherDataList) {
        if (weatherDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherData>(){}.getType();

        return gson.toJson(weatherDataList, type);
    }

    @Override
    public WeatherData convertToEntityAttribute(String weatherIDData) {
        if (weatherIDData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherData>(){}.getType();

        return gson.fromJson(weatherIDData, type); 
    }
}
