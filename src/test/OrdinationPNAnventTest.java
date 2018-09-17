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

    @Before
    public void setUp() {
        lm = new Laegemiddel("Testimol", 10, 20, 30, "ml");
        controller = Controller.getController();
    }

    @Test
    public void TC1_ordinationPNAnvendt() {
        PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
        controller.ordinationPNAnvendt(pn, LocalDate.of(2000, 01, 03));

        assertEquals(1, pn.getAntalGangeGivet());
    }

}
