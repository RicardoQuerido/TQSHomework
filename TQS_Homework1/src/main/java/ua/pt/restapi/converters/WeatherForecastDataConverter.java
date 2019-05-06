package ua.pt.restapi.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.WeatherForecastData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 *
 * @author Ricardo Querido
 */
@Converter
public class WeatherForecastDataConverter implements AttributeConverter<WeatherForecastData, String> {

    @Override
    public String convertToDatabaseColumn(WeatherForecastData weatherForecastDataList) {
        if (weatherForecastDataList == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherForecastData>() {
        }.getType();

        return gson.toJson(weatherForecastDataList, type);
    }

    @Override
    public WeatherForecastData convertToEntityAttribute(String weatherForecastData) {
        if (weatherForecastData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<WeatherForecastData>() {
        }.getType();

        return gson.fromJson(weatherForecastData, type);
    }

}
