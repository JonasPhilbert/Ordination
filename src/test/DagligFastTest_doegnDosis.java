package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ordination.DagligFast;
import ordination.Dagstidspunkt;
import ordination.Laegemiddel;

public class DagligFastTest_doegnDosis {

    /** Test af metoden doegnDosis() i klassen DagligFast */

    DagligFast df;

    @Before
    public void setUp_doegnDosis() {
        df = new DagligFast(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 06),
                new Laegemiddel("Ipren", 100, 10, 99, "Kg"));
    }

    @Test
    public void TC1_doegnDosis() {
        double resultat = df.doegnDosis();
        assertEquals(0, resultat, 0.01);
    }

    @Test
    public void TC2_doegnDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 10);
        double resultat = df.doegnDosis();
        assertEquals(10, resultat, 0.01);
    }

    @Test
    public void TC3_doegnDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 20);
        double resultat = df.doegnDosis();
        assertEquals(20, resultat, 0.01);
    }

    @Test
    public void TC4_doegnDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 40);
        double resultat = df.doegnDosis();
        assertEquals(40, resultat, 0.01);
    }
}
