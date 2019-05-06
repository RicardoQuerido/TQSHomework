package ua.pt.restapi.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ricardo Querido
 */
public class CacheStatsTest {

    private CacheStats cst;

    public CacheStatsTest() {
    }

    @BeforeEach
    public void setUp() {
        cst = new CacheStats(1, 2, 3);
    }

    @AfterEach
    public void tearDown() {
        cst = null;
    }

    /**
     * Test of getNumberOfRequests method, of class CacheStats.
     */
    @Test
    public void testGetNumberOfRequests() {
        int expResult = 1;
        int result = cst.getNumberOfRequests();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfRequests method, of class CacheStats.
     */
    @Test
    public void testSetNumberOfRequests() {
        int numberOfRequests = 0;
        cst.setNumberOfRequests(numberOfRequests);
        assertEquals(numberOfRequests, cst.getNumberOfRequests());
    }

    /**
     * Test of getNumberOfHits method, of class CacheStats.
     */
    @Test
    public void testGetNumberOfHits() {
        int expResult = 2;
        int result = cst.getNumberOfHits();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfHits method, of class CacheStats.
     */
    @Test
    public void testSetNumberOfHits() {
        int numberOfHits = 0;
        cst.setNumberOfHits(numberOfHits);
        assertEquals(numberOfHits, cst.getNumberOfHits());
    }

    /**
     * Test of getNumberOfMisses method, of class CacheStats.
     */
    @Test
    public void testGetNumberOfMisses() {
        int expResult = 3;
        int result = cst.getNumberOfMisses();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumberOfMisses method, of class CacheStats.
     */
    @Test
    public void testSetNumberOfMisses() {
        int numberOfMisses = 0;
        cst.setNumberOfMisses(numberOfMisses);
        assertEquals(numberOfMisses, cst.getNumberOfMisses());
    }

    /**
     * Test of toString method, of class CacheStats.
     */
    @Test
    public void testToString() {
        cst.setId(34L);
        String expResult = "CacheStats{" + "id=" + 34L + ", numberOfRequests=" + 1 + ", numberOfHits=" + 2 + ", numberOfMisses=" + 3 + '}';
        String result = cst.toString();
        assertEquals(expResult, result);
    }

}
