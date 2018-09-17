package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Patient;

public class Controller_opretPatient {

    Controller controller;

    @Before
    public void setUp() {
        controller = Controller.getController();
    }

    @Test
    public void TC1_opretPatient() {
        Patient p = controller.opretPatient("Hans Hansen", "1234567890", 65);

        assertNotNull(p);
        assertEquals("Hans Hansen", p.getNavn());
        assertEquals("1234567890", p.getCprnr());
        assertEquals(65, p.getVaegt(), 0.01);
    }

    @Test
    public void TC2_opretPatient() {
        Patient p = controller.opretPatient("Hans Hansen", "1234567890", -20);

        p.getVaegt();
    }
}
