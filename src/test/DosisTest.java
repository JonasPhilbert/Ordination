package test;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import ordination.Dosis;

public class DosisTest {

    /** Test af metoden setTid() i klassen Dosis */

    @Test
    public void TC1() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(00, 00));
        assertEquals(LocalTime.of(00, 00), d.getTid());
    }

    @Test
    public void TC2() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(12, 00));
        assertEquals(LocalTime.of(12, 00), d.getTid());
    }

    @Test
    public void TC3() {
        Dosis d = new Dosis(0);
        d.setTid(LocalTime.of(23, 59));
        assertEquals(LocalTime.of(23, 59), d.getTid());
    }

    @Test
    public void TC4() {
        Dosis d = new Dosis(0);
        d.setTid(null);
        assertEquals(null, d.getTid());

    }

}
