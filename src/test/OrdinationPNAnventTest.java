package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.PN;

public class OrdinationPNAnventTest {

    Laegemiddel lm;
    Controller controller;
    PN pn;

    @Before
    public void setUp() {
        lm = new Laegemiddel("Testimol", 10, 20, 30, "ml");
        controller = Controller.getController();
        pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
    }

    @Test
    public void TC1_ordinationPNAnvendt() {
        controller.ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 03));

        assertEquals(1, pn.getAntalGangeGivet());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TC2_ordinationPNAnvendt() {
        controller.ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 06));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TC3_ordinationPNAnvendt() {
        controller.ordinationPNAnvendt(null, LocalDate.of(2000, 01, 05));
    }

}
