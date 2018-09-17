package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ordination.DagligFast;
import ordination.Dagstidspunkt;
import ordination.Dosis;
import ordination.Laegemiddel;

public class DagligFastTest {

    DagligFast df;

    @Before
    public void setUp_doegnDosis() {
        df = new DagligFast(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05),
                new Laegemiddel("Ipren", 100, 10, 99, "Kg"));
    }

    /** Test af metoden createDosis() i klassen DagligFast */

    @Test
    public void TC1_createDosis() {
        Dosis dosis = df.createDosis(Dagstidspunkt.MORGEN, 0);
        Dosis dosisNew = new Dosis(0);
        assertEquals(dosis.getAntal(), dosisNew.getAntal(), 0.01);
    }

    @Test
    public void TC2_createDosis() {
        Dosis dosis = df.createDosis(Dagstidspunkt.MIDDAG, 10);
        Dosis dosisNew = new Dosis(10);
        assertEquals(dosis.getAntal(), dosisNew.getAntal(), 0.01);
    }

    @Test
    public void TC3_createDosis() {
        Dosis dosis = df.createDosis(Dagstidspunkt.AFTEN, -1);
        Dosis dosisNew = new Dosis(-1);
        assertEquals(dosis.getAntal(), dosisNew.getAntal(), 0.01);
    }

    /** Test af metoden doegnDosis() i klassen DagligFast */

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

    /** Test af metoden samletDosis() i klassen DagligFast */

    @Test
    public void TC1_samletDosis() {
        assertEquals(0, df.samletDosis(), 0.01);
    }

    @Test
    public void TC2_samletDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 10);
        assertEquals(50, df.samletDosis(), 0.01);
    }

    @Test
    public void TC3_samletDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 10);
        df.createDosis(Dagstidspunkt.MIDDAG, 10);
        assertEquals(100, df.samletDosis(), 0.01);
    }

    @Test
    public void TC4_samletDosis() {
        df.createDosis(Dagstidspunkt.MORGEN, 10);
        df.createDosis(Dagstidspunkt.MIDDAG, 10);
        df.createDosis(Dagstidspunkt.AFTEN, 10);
        df.createDosis(Dagstidspunkt.NAT, 10);
        assertEquals(200, df.samletDosis(), 0.01);
    }
}
