package ua.pt.restapi.models;

import java.io.Serializable;
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
import ua.pt.restapi.converters.WeatherDataConverter;

/**
 *
 * @author Ricardo Querido
 */
@Entity
@Table(name = "weather")
@NamedQuery(name = "Weather.findAll", query = "SELECT t FROM Weather t")
public class Weather implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String owner;

    @Column
    private String country;

    @Column
    @ElementCollection
    @Convert(converter = WeatherDataConverter.class)
    @OneToMany(fetch = FetchType.EAGER, mappedBy="WeatherData")
    private List<WeatherData> data;

    public Weather() {
    }

    public Weather(String owner, String country, List<WeatherData> data) {
        this.owner = owner;
        this.country = country;
        this.data = data;
    }

    public long getId() { return id; }
    public String getOwner() { return owner; }
    public String getCountry() { return country; }
    public List<WeatherData> getData() {
        return data;
    }

    // SETTERS:
    public void setId(long id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCountry(String country) { this.country = country; }
    public void setData(List<WeatherData> data) {
        this.data = data;
    }


}
