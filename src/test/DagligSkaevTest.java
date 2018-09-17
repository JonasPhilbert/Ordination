package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;

public class DagligSkaevTest {
    
	/** Test af metoden doegnDosis() i klassen DagligSkaev */

    DagligSkaev ds;
    Dosis dosis;

    @Before
    public void setUp() {
        ds = new DagligSkaev(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05),
                new Laegemiddel("Ipren", 100, 10, 99, "KG"));
    }

    @Test
    public void TC1_doegnDosis() {
        double resultat = ds.doegnDosis();
        assertEquals(0, resultat, 0.01);
    }

    @Test
    public void TC2_doegnDosis() {
        ds.opretDosis(LocalTime.now(), 10);
        double resultat = ds.doegnDosis();
        assertEquals(10, resultat, 0.01);
    }

    @Test
    public void TC3_doegnDosis() {
        ds.opretDosis(LocalTime.now(), 20);
        double resultat = ds.doegnDosis();
        assertEquals(20, resultat, 0.01);
    }

    @Test
    public void TC4_doegnDosis() {
        ds.opretDosis(LocalTime.now(), 50);
        double resultat = ds.doegnDosis();
        assertEquals(50, resultat, 0.01);
    }

    /** Test af metoden samletDosis() i klassen DagligSkaev */
    
    @Test
    public void TC1_samletDosis() {
    	double resultat = ds.samletDosis();
    	assertEquals(0, resultat, 0.01);
    }
    
    @Test
    public void TC2_samletDosis() {
    	ds.opretDosis(LocalTime.now(), 10);
    	ds.opretDosis(LocalTime.now(), 10);
    	double resultat = ds.samletDosis();
    	assertEquals(100, resultat, 0.01);
    }
    
    @Test
    public void TC3_samletDosis() {
    	ds.opretDosis(LocalTime.now(), 10);
    	ds.opretDosis(LocalTime.now(), 10);
    	ds.opretDosis(LocalTime.now(), 10);
    	double resultat = ds.samletDosis();
    	assertEquals(150, resultat, 0.01);
    }
    
    /** Test af metoden opretDosis() i klassen dagligSkaev */
    
    @Test 
    public void TC1_opretDosis() {
    	ds.opretDosis(LocalTime.MIDNIGHT, 1);
    	Dosis d = ds.getDoser().get(0);
    	assertNotNull(d);
    	assertEquals(LocalTime.MIDNIGHT, d.getTid());
    	assertEquals(1, d.getAntal(), 0.01);
     }
    
    @Test
    public void TC2_opretDosis() {
    	ds.opretDosis(LocalTime.NOON, 10);
    	Dosis d = ds.getDoser().get(0);
    	assertNotNull(d);
    	assertEquals(LocalTime.NOON, d.getTid());
    	assertEquals(10, d.getAntal(), 0.01);
    }
    
    @Test 
    public void TC3_opretDosis() {
    	ds.opretDosis(LocalTime.of(23, 59), 100);
    	Dosis d = ds.getDoser().get(0);
    	assertNotNull(d);
    	assertEquals(LocalTime.of(23, 59), d.getTid());
    	assertEquals(100, d.getAntal(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void TC4_opretDosis() {
    	ds.opretDosis(LocalTime.of(13, 00), 0);
    	Dosis d = ds.getDoser().get(0);
    	assertNotNull(d);
    	assertEquals(LocalTime.of(13, 00), d.getTid());
    	assertEquals(0, d.getAntal(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void TC5_opretDosis() {
    	ds.opretDosis(LocalTime.of(11, 00), -1);
    	Dosis d = ds.getDoser().get(0);
    	assertNotNull(d);
    	assertEquals(LocalTime.of(13, 00), d.getTid());
    	assertEquals(-1, d.getAntal(), 0.01);
    }
    
    
    
    
}
