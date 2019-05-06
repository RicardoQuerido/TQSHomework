package ua.pt.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ua.pt.restapi.converters.WeatherForecastDataConverter;

@Entity
@Table(name = "weatherforecast")
@NamedQuery(name = "WeatherForecast.findAll", query = "SELECT t FROM WeatherForecast t")
public class WeatherForecast implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String owner;

    @Column
    private String country;

    @Column
    @ElementCollection
    @Convert(converter = WeatherForecastDataConverter.class)
    @OneToMany(fetch = FetchType.EAGER, mappedBy="WeatherForecastData")
    private List<WeatherForecastData> data = new ArrayList<>();

    @Column
    private int globalIdLocal;

    @Column
    private String dataUpdate;

    @Column
    private Date lastRefresh;

    public WeatherForecast() {
    }

    public WeatherForecast(String owner, String country, List<WeatherForecastData> data, int globalIdLocal, String dataUpdate, Date lastRefresh) {
        this.owner = owner;
        this.country = country;
        this.data = data;
        this.globalIdLocal = globalIdLocal;
        this.dataUpdate = dataUpdate;
        this.lastRefresh = lastRefresh;
    }

    public WeatherForecast(String owner, String country, List<WeatherForecastData> data, int globalIdLocal, String dataUpdate) {
        this.owner = owner;
        this.country = country;
        this.data = data;
        this.globalIdLocal = globalIdLocal;
        this.dataUpdate = dataUpdate;
    }

    // GETTERS:
    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getCountry() {
        return country;
    }

    public int getGlobalIdLocal() {
        return globalIdLocal;
    }

    public String getDataUpdate() {
        return dataUpdate;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public List<WeatherForecastData> getData() {
        return data;
    }

    // SETTERS:
    public void setId(long id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGlobalIdLocal(int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public void setDataUpdate(String dataUpdate) {
        this.dataUpdate = dataUpdate;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    public void setData(List<WeatherForecastData> data) {
        this.data = data;
    }
}
