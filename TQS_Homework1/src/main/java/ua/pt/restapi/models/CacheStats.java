package ua.pt.restapi.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ricardo Querido
 */
@Entity
@Table(name = "cacheStats")
@NamedQuery(name = "CacheStats.find", query = "SELECT t FROM CacheStats t")
public class CacheStats implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column
    private int numberOfRequests;
    
    @Column
    private int numberOfHits;
    
    @Column
    private int numberOfMisses;

    public CacheStats() {
    }
    
    public CacheStats(int numberOfRequests, int numberOfHits, int numberOfMisses) {
        this.numberOfRequests = numberOfRequests;
        this.numberOfHits = numberOfHits;
        this.numberOfMisses = numberOfMisses;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public int getNumberOfRequests() {
        return numberOfRequests;
    }
    public void setNumberOfRequests(int numberOfRequests) {
        this.numberOfRequests = numberOfRequests;
    }

    public int getNumberOfHits() {
        return numberOfHits;
    }
    public void setNumberOfHits(int numberOfHits) {
        this.numberOfHits = numberOfHits;
    }

    public int getNumberOfMisses() {
        return numberOfMisses;
    }
    public void setNumberOfMisses(int numberOfMisses) {
        this.numberOfMisses = numberOfMisses;
    }

    @Override
    public String toString() {
        return "CacheStats{" + "id=" + id + ", numberOfRequests=" + numberOfRequests + ", numberOfHits=" + numberOfHits + ", numberOfMisses=" + numberOfMisses + '}';
    }
}
