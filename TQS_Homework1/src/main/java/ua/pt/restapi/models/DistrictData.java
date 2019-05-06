package ua.pt.restapi.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "districtData")
public class DistrictData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int idRegiao;

    @Column
    private String idAreaAviso;

    @Column
    private int idConcelho;

    @Column
    private int globalIdLocal;

    @Column
    private String latitude;

    @Column
    private int idDistrito;

    @Column
    private String local;

    @Column
    private String longitude;

    public DistrictData() {
    }

    public DistrictData(int idRegiao, String idAreaAviso, int idConcelho, int globalIdLocal, String latitude, int idDistrito, String local, String longitude) {
        this.idRegiao = idRegiao;
        this.idAreaAviso = idAreaAviso;
        this.idConcelho = idConcelho;
        this.globalIdLocal = globalIdLocal;
        this.latitude = latitude;
        this.idDistrito = idDistrito;
        this.local = local;
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }
    public int getIdRegiao() { return idRegiao; }
    public String getIdAreaAviso() { return idAreaAviso; }
    public int getIdConcelho() { return idConcelho; }
    public int getGlobalIdLocal() { return globalIdLocal; }
    public String getLatitude() { return latitude; }
    public int getIdDistrito() { return idDistrito; }
    public String getLocal() { return local; }
    public String getLongitude() { return longitude; }


    public void setId(long id) {
        this.id = id;
    }
    public void setIdRegiao(int idRegiao) { this.idRegiao = idRegiao; }
    public void setIdAreaAviso(String idAreaAviso) { this.idAreaAviso = idAreaAviso; }
    public void setIdConcelho(int idConcelho) { this.idConcelho = idConcelho; }
    public void setGlobalIdLocal(int globalIdLocal) { this.globalIdLocal = globalIdLocal; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public void setIdDistrito(int idDistrito) { this.idDistrito = idDistrito; }
    public void setLocal(String local) { this.local = local; }
    public void setLongitude(String longitude) { this.longitude = longitude; }

    
    
}
