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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import ua.pt.restapi.converters.DistrictDataConverter;

/**
 *
 * @author Ricardo Querido
 */
@Entity
@Table(name = "district")
@NamedQuery(name = "District.findAll", query = "SELECT t FROM District t")
public class District implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String owner;
    
    @Column
    private String country;
    
    @Column
    @ElementCollection
    @Convert(converter = DistrictDataConverter.class)
    @OneToMany
    private List<DistrictData> data;

    public District() {
    }

    
    public District(String owner, String country, List<DistrictData> data) {
        this.owner = owner;
        this.country = country;
        this.data = data;
    }

    public Long getId() { return id; }
    public String getOwner() { return owner; }
    public String getCountry() { return country; }
    public List<DistrictData> getData() {
        return data;
    }

    // SETTERS:
    public void setId(Long id) { this.id = id; }
    public void setOwner(String owner) { this.owner = owner; }
    public void setCountry(String country) { this.country = country; }
    public void setData(List<DistrictData> data) {
        this.data = data;
    }
}
