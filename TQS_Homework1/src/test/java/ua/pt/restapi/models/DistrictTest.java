package ua.pt.restapi.models;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class DistrictTest {
    
    private District dt;
    List<DistrictData> data;
    
    
    public DistrictTest() {
    }
    
    @BeforeEach
    public void setUp() {
        data = Arrays.asList(new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700"), new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),
        new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        dt = new District("IPMA", "Portugal", data);
    }
    
    @AfterEach
    public void tearDown() {
        dt = null;
        data = null;
    }

    /**
     * Test of getOwner method, of class District.
     */
    @Test
    public void testGetOwner() {
        String expResult = "IPMA";
        String result = dt.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountry method, of class District.
     */
    @Test
    public void testGetCountry() {
        String expResult = "Portugal";
        String result = dt.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class District.
     */
    @Test
    public void testGetData() {
        List<DistrictData> expResult = data;
        List<DistrictData> result = dt.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOwner method, of class District.
     */
    @Test
    public void testSetOwner() {
        String owner = "Mário Soares";
        dt.setOwner(owner);
        assertEquals(owner, dt.getOwner());
    }

    /**
     * Test of setCountry method, of class District.
     */
    @Test
    public void testSetCountry() {
        String country = "Islândia";
        dt.setCountry(country);
        assertEquals(country, dt.getCountry());
    }

    /**
     * Test of setData method, of class District.
     */
    @Test
    public void testSetData() {
        List<DistrictData> data = Arrays.asList(new DistrictData(1, "BRG", 3, 1030300, "41.5475", 3, "Braga", "-8.4227"),new DistrictData(1, "BGC", 2, 1040200, "41.8076", 4, "Bragança", "-6.7606"));
        dt.setData(data);
        assertEquals(data, dt.getData());
    }
    
}
