package ua.pt.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"classPrecInt"})
public class WeatherForecastData implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String precipitaProb;

    @Column
    @JsonProperty("tMin")
    private String tMin;

    @Column
    @JsonProperty("tMax")
    private String tMax;

    @Column
    private String predWindDir;

    @Column
    private int idWeatherType;

    @Column
    private int classWindSpeed;

    @Column
    private String longitude;

    @Column
    private String forecastDate;

    @Column
    private String latitude;

    public WeatherForecastData() {
    }

    public WeatherForecastData(String precipitaProb, String tempMin, String tempMax, String predWindDir, int idWeatherType, int classWindSpeed, String longitude, String forecastDate, String latitude) {
        this.precipitaProb = precipitaProb;
        this.tMin = tempMin;
        this.tMax = tempMax;
        this.predWindDir = predWindDir;
        this.idWeatherType = idWeatherType;
        this.classWindSpeed = classWindSpeed;
        this.longitude = longitude;
        this.forecastDate = forecastDate;
        this.latitude = latitude;
    }

    public long getId() {
        return id;
    }

    public String getPrecipitaProb() {
        return precipitaProb;
    }

    public String getPredWindDir() {
        return predWindDir;
    }

    public int getIdWeatherType() {
        return idWeatherType;
    }

    public int getClassWindSpeed() {
        return classWindSpeed;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public String getLatitude() {
        return latitude;
    }

    public String gettMin() {
        return tMin;
    }

    public String gettMax() {
        return tMax;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrecipitaProb(String precipitaProb) {
        this.precipitaProb = precipitaProb;
    }

    public void setPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
    }

    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public void setClassWindSpeed(int classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void settMin(String tMin) {
        this.tMin = tMin;
    }

    public void settMax(String tMax) {
        this.tMax = tMax;
    }

    @Override
    public String toString() {
        return "WeatherForecastData{" + "\nid=" + id + ", \nprecipitaProb=" + precipitaProb + ", \ntempMin=" + tMin + ", \ntempMax=" + tMax + ", \npredWindDir=" + predWindDir + ", \nidWeatherType=" + idWeatherType + ", \nclassWindSpeed=" + classWindSpeed + ", \nlongitude=" + longitude + ", \nforecastDate=" + forecastDate + ", \nlatitude=" + latitude + '}';
    }

}
