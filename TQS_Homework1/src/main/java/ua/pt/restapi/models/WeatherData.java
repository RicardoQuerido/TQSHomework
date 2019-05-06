package ua.pt.restapi.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "weatherData")
@NamedQuery(name = "WeatherData.findAll", query = "SELECT t FROM WeatherData t")
public class WeatherData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String descIdWeatherTypeEN;

    @Column
    private String descIdWeatherTypePT;

    @Column
    private int idWeatherType;

    public WeatherData() {
    }


    public WeatherData(String descIdWeatherTypeEN, String descIdWeatherTypePT, int idWeatherType) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
        this.descIdWeatherTypePT = descIdWeatherTypePT;
        this.idWeatherType = idWeatherType;
    }


    public long getId() {
        return id;
    }
    public String getDescIdWeatherTypeEN() {
        return descIdWeatherTypeEN;
    }
    public int getIdWeatherType() {
        return idWeatherType;
    }
    public String getDescIdWeatherTypePT() {
        return descIdWeatherTypePT;
    }


    public void setId(long id) {
        this.id = id;
    }
    public void setDescIdWeatherTypeEN(String descIdWeatherTypeEN) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
    }
    public void setDescIdWeatherTypePT(String descIdWeatherTypePT) {
        this.descIdWeatherTypePT = descIdWeatherTypePT;
    }
    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }
}
