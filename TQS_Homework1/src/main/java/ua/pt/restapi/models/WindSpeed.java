package ua.pt.restapi.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ua.pt.restapi.converters.WindSpeedDataConverter;

@Entity
@Table(name = "windspeed")
@NamedQuery(name = "WindSpeed.findAll", query = "SELECT t FROM WindSpeed t")
public class WindSpeed implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String owner;

    @Column
    private String country;

    @Column
    @ElementCollection
    @Convert(converter = WindSpeedDataConverter.class)
    @OneToMany(fetch = FetchType.EAGER, mappedBy="WindSpeedData")
    private List<WindSpeedData> data;

    public WindSpeed() {
    }


    public WindSpeed(String owner, String country, List<WindSpeedData> data) {
        this.owner = owner;
        this.country = country;
        this.data = data;
    }

    // GETTERS:

    public long getId() { return id; }
    public String getOwner() { return owner; }
    public String getCountry() { return country; }
    public List<WindSpeedData> getData() {
        return data;
    }


    // SETTERS:
    public void setId(long id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCountry(String country) { this.country = country; }
    public void setData(List<WindSpeedData> data) {
        this.data = data;
    }

}
