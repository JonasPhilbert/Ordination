package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Patient;

public class Controller_opretPatientTest {

    Controller controller;

    @Before
    public void setUp() {
        controller = Controller.getController();
    }

    @Test
    public void TC1_opretPatient() {
        Patient p = controller.opretPatient("1234567890", "Hans Hansen", 65);

        assertNotNull(p);
        assertEquals("Hans Hansen", p.getNavn());
        assertEquals("1234567890", p.getCprnr());
        assertEquals(65, p.getVaegt(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TC2_opretPatient() {
        Patient p = controller.opretPatient("1234567890", "Hans Hansen", -20);

        assertEquals(-20, p.getVaegt(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TC3_opretPatient() {
        Patient p = controller.opretPatient("123456", "Hans Hansen", 65);

        assertEquals(10, p.getCprnr().length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TC4_opretPatient() {
        Patient p = controller.opretPatient("1234567890", null, 65);

        assertEquals("Hans Hansen", p.getNavn());
    }
}
