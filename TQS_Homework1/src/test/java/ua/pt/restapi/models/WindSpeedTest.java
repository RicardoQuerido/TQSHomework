package ua.pt.restapi.models;

import java.io.IOException;
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
public class WindSpeedTest {
    
    private List<WindSpeedData> wsd;
    private WindSpeed ws;
    
    public WindSpeedTest() {
    }
    
    @BeforeEach
    public void setUp() {
        wsd = Arrays.asList(new WindSpeedData("Weak", "Fraco", "1"), new WindSpeedData("Moderate", "Moderado", "2"));
        ws = new WindSpeed("IPMA", "PT", wsd);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getOwner method, of class WindSpeed.
     */
    @Test
    public void testGetOwner() throws IOException {
        String expResult = "IPMA";
        String result = ws.getOwner();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountry method, of class WindSpeed.
     */
    @Test
    public void testGetCountry() {
        String expResult = "PT";
        String result = ws.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getData method, of class WindSpeed.
     */
    @Test
    public void testGetData() {
        List<WindSpeedData> expResult = wsd;
        List<WindSpeedData> result = ws.getData();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class WindSpeed.
     */
    @Test
    public void testSetId() {
        long id = 34L;
        ws.setId(id);
        assertEquals(id, ws.getId());
    }

    /**
     * Test of setOwner method, of class WindSpeed.
     */
    @Test
    public void testSetOwner() {
        String owner = "LIVID";
        ws.setOwner(owner);
        assertEquals(owner, ws.getOwner());
    }

    /**
     * Test of setCountry method, of class WindSpeed.
     */
    @Test
    public void testSetCountry() {
        String country = "ES";
        ws.setCountry(country);
        assertEquals(country, ws.getCountry());
    }

    /**
     * Test of setData method, of class WindSpeed.
     */
    @Test
    public void testSetData() {
        List<WindSpeedData> data = wsd;
        ws.setData(data);
        assertEquals(data, ws.getData());
    }
    
}
