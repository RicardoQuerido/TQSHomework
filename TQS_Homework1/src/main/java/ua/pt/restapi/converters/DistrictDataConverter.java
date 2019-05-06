package ua.pt.restapi.converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import ua.pt.restapi.models.DistrictData;

/**
 *
 * @author Ricardo Querido
 */
@Converter(autoApply=true)
public class DistrictDataConverter implements AttributeConverter<DistrictData, String>{

    @Override
    public String convertToDatabaseColumn(DistrictData x) {
        
        if (x == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<DistrictData>(){}.getType();

        return gson.toJson(x, type);
    }

    @Override
    public DistrictData convertToEntityAttribute(String districtIDData) {
        
        if (districtIDData == null) {
            return (null);
        }

        Gson gson = new Gson();
        Type type = new TypeToken<DistrictData>(){}.getType();

        return gson.fromJson(districtIDData, type);
    }
    
}
