package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;
import ordination.DagligSkaev;
import ordination.Laegemiddel;

public class DagligSkaevTest {
    /** Test af metoden doegnDosis() i klassen DagligSkaev */

    DagligSkaev ds;

    @Before
    public void setUp() {
        ds = new DagligSkaev(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 06),
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

}
