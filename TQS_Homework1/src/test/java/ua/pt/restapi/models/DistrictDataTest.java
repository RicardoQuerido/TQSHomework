package ua.pt.restapi.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class DistrictDataTest {

    private DistrictData dd;

    public DistrictDataTest() {
    }

    @BeforeEach
    public void setUp() {
        dd = new DistrictData(1, "BJA", 5, 1020500, "38.0200", 2, "Beja", "-7.8700");
    }

    @AfterEach
    public void tearDown() {
        dd = null;
    }

    /**
     * Test of getIdRegiao method, of class DistrictData.
     */
    @Test
    public void testGetIdRegiao() {
        int expResult = 1;
        int result = dd.getIdRegiao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdAreaAviso method, of class DistrictData.
     */
    @Test
    public void testGetIdAreaAviso() {
        String expResult = "BJA";
        String result = dd.getIdAreaAviso();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdConcelho method, of class DistrictData.
     */
    @Test
    public void testGetIdConcelho() {
        int expResult = 5;
        int result = dd.getIdConcelho();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGlobalIdLocal method, of class DistrictData.
     */
    @Test
    public void testGetGlobalIdLocal() {
        int expResult = 1020500;
        int result = dd.getGlobalIdLocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLatitude method, of class DistrictData.
     */
    @Test
    public void testGetLatitude() {
        String expResult = "38.0200";
        String result = dd.getLatitude();
        assertEquals(expResult, result);;
    }

    /**
     * Test of getIdDistrito method, of class DistrictData.
     */
    @Test
    public void testGetIdDistrito() {
        int expResult = 2;
        int result = dd.getIdDistrito();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocal method, of class DistrictData.
     */
    @Test
    public void testGetLocal() {
        String expResult = "Beja";
        String result = dd.getLocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLongitude method, of class DistrictData.
     */
    @Test
    public void testGetLongitude() {
        String expResult = "-7.8700";
        String result = dd.getLongitude();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class DistrictData.
     */
    @Test
    public void testSetId() {
        long id = 0L;
        dd.setId(id);
        assertEquals(id, dd.getId());
    }

    /**
     * Test of setIdRegiao method, of class DistrictData.
     */
    @Test
    public void testSetIdRegiao() {
        int idRegiao = 0;
        dd.setIdRegiao(idRegiao);
        assertEquals(idRegiao, dd.getIdRegiao());
    }

    /**
     * Test of setIdAreaAviso method, of class DistrictData.
     */
    @Test
    public void testSetIdAreaAviso() {
        String idAreaAviso = "AVR";
        dd.setIdAreaAviso(idAreaAviso);
        assertEquals(idAreaAviso, dd.getIdAreaAviso());
    }

    /**
     * Test of setIdConcelho method, of class DistrictData.
     */
    @Test
    public void testSetIdConcelho() {
        int idConcelho = 0;
        dd.setIdConcelho(idConcelho);
        assertEquals(idConcelho, dd.getIdConcelho());
    }

    /**
     * Test of setGlobalIdLocal method, of class DistrictData.
     */
    @Test
    public void testSetGlobalIdLocal() {
        int globalIdLocal = 0;
        dd.setGlobalIdLocal(globalIdLocal);
        assertEquals(globalIdLocal, dd.getGlobalIdLocal());
    }

    /**
     * Test of setLatitude method, of class DistrictData.
     */
    @Test
    public void testSetLatitude() {
        String latitude = "34.555";
        dd.setLatitude(latitude);
        assertEquals(latitude, dd.getLatitude());
    }

    /**
     * Test of setIdDistrito method, of class DistrictData.
     */
    @Test
    public void testSetIdDistrito() {
        int idDistrito = 0;
        dd.setIdDistrito(idDistrito);
        assertEquals(idDistrito, dd.getIdDistrito());
    }

    /**
     * Test of setLocal method, of class DistrictData.
     */
    @Test
    public void testSetLocal() {
        String local = "Aveiro";
        dd.setLocal(local);
        assertEquals(local, dd.getLocal());
    }

    /**
     * Test of setLongitude method, of class DistrictData.
     */
    @Test
    public void testSetLongitude() {
        String longitude = "-7.8989";
        dd.setLongitude(longitude);
        assertEquals(longitude, dd.getLongitude());
    }

}
