package test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import ordination.Dosis;

public class DosisTest_get_setTid {

    /** Test af metoden getTid() i klassen Dosis */

    @Test
    public void TC1_getTid() {
        Dosis d = new Dosis(LocalTime.of(00, 00), 0);
        assertEquals(LocalTime.of(00, 00), d.getTid());
    }

    /** Test af metoden setTid() i klassen Dosis */

    @Test
    public void TC1_setTid() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(00, 00));
        assertEquals(LocalTime.of(00, 00), d.getTid());
    }

    @Test
    public void TC2_setTid() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(12, 00));
        assertEquals(LocalTime.of(12, 00), d.getTid());
    }

    @Test
    public void TC3_setTid() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(23, 59));
        assertEquals(LocalTime.of(23, 59), d.getTid());
    }

    @Test
    public void TC4_setTid() {
        Dosis d = new Dosis(0);
        d.setTid(null);
        assertEquals(null, d.getTid());

    }

}
