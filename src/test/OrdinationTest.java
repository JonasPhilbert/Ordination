package test;

import static org.junit.Assert.assertEquals;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.Test;

import ordination.DagligFast;
import ordination.Laegemiddel;

public class OrdinationTest {

    @Test
    public void TC1_antalDage() {
        DagligFast df = new DagligFast(LocalDate.of(2018, 07, 10), LocalDate.of(2018, 07, 18),
                new Laegemiddel("Ipren", 100, 10, 99, "Kg"));

        assertEquals(9, df.antalDage());
    }

    @Test(expected = DateTimeException.class)
    public void TC2_antalDage() {
        DagligFast dfFejl = new DagligFast(LocalDate.of(2018, 07, 14), LocalDate.of(2018, 07, 10),
                new Laegemiddel("Ipren", 100, 10, 99, "Kg"));

        assertEquals(9, dfFejl.antalDage());
    }

}
