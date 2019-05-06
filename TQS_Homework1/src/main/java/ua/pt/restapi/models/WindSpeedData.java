package ua.pt.restapi.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WindSpeedData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String descClassWindSpeedDailyEN;

    @Column
    private String descClassWindSpeedDailyPT;

    @Column
    private String classWindSpeed;

    public WindSpeedData() {
    }

    public WindSpeedData(String descClassWindSpeedDailyEN, String descClassWindSpeedDailyPT, String classWindSpeed) {
        this.descClassWindSpeedDailyEN = descClassWindSpeedDailyEN;
        this.descClassWindSpeedDailyPT = descClassWindSpeedDailyPT;
        this.classWindSpeed = classWindSpeed;
    }


    public long getId() {
        return id;
    }
    public String getDescClassWindSpeedDailyEN() { return descClassWindSpeedDailyEN; }
    public String getDescClassWindSpeedDailyPT() { return descClassWindSpeedDailyPT; }
    public String getClassWindSpeed() { return classWindSpeed; }



    public void setId(long id) {
        this.id = id;
    }
    public void setDescClassWindSpeedDailyEN(String descClassWindSpeedDailyEN) { this.descClassWindSpeedDailyEN = descClassWindSpeedDailyEN; }
    public void setDescClassWindSpeedDailyPT(String descClassWindSpeedDailyPT) { this.descClassWindSpeedDailyPT = descClassWindSpeedDailyPT; }
    public void setClassWindSpeed(String classWindSpeed) { this.classWindSpeed = classWindSpeed; }
}
