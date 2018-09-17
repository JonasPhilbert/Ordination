package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;

public class ControllerOpretPatientLaegemiddel {

    Controller c;

    @Before
    public void setUp() {
        c = Controller.getController();
    }

    
    // opretPatient
    @Test
    public void opretPatientTC1() {
        Patient p = c.opretPatient("123456-7890", "Hans Hansen", 65);

        assertNotNull(p);
        assertEquals("Hans Hansen", p.getNavn());
        assertEquals("123456-7890", p.getCprnr());
        assertEquals(65, p.getVaegt(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void opretPatientTC2() {
        Patient p = c.opretPatient("123456-7890", "Hans Hansen", -20);

        assertEquals(-20, p.getVaegt(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void opretPatientTC3() {
        Patient p = c.opretPatient("123456", "Hans Hansen", 65);

        assertEquals(11, p.getCprnr().length());
    }

    @Test(expected = IllegalArgumentException.class)
    public void opretPatientTC4() {
        Patient p = c.opretPatient("123456-7890", null, 65);

        assertEquals("Hans Hansen", p.getNavn());
    }
    
    // opretLaegemiddel
    @Test
    public void opretLaegemiddelTC1() {
    	Laegemiddel l = c.opretLaegemiddel("Testimol", 1, 10, 900, "mg");
    	
    	assertEquals("Testimol", l.getNavn());
    	assertEquals(1, l.getEnhedPrKgPrDoegnLet(), 0.001d);
    	assertEquals(10, l.getEnhedPrKgPrDoegnNormal(), 0.001d);
    	assertEquals(900, l.getEnhedPrKgPrDoegnTung(), 0.001d);
    	assertEquals("mg", l.getEnhed());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void opretLaegemiddelTC3() {
    	Laegemiddel l = c.opretLaegemiddel("Testafonal", 0, 5, 5, "g");
    	
    	assertEquals("Testafonal", l.getNavn());
    	assertEquals(0, l.getEnhedPrKgPrDoegnLet(), 0.001d);
    	assertEquals(5, l.getEnhedPrKgPrDoegnNormal(), 0.001d);
    	assertEquals(5, l.getEnhedPrKgPrDoegnTung(), 0.001d);
    	assertEquals("g", l.getEnhed());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void opretLaegemiddelTC4() {
    	Laegemiddel l = c.opretLaegemiddel("Testaminil", 5, -1, 10, "kg");
    	
    	assertEquals("Testaminil", l.getNavn());
    	assertEquals(5, l.getEnhedPrKgPrDoegnLet(), 0.001d);
    	assertEquals(-1, l.getEnhedPrKgPrDoegnNormal(), 0.001d);
    	assertEquals(10, l.getEnhedPrKgPrDoegnTung(), 0.001d);
    	assertEquals("kg", l.getEnhed());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void opretLaegemiddelTC5() {
    	Laegemiddel l = c.opretLaegemiddel("", 5, 10, 15, "gr");
    	
    	assertEquals("", l.getNavn());
    	assertEquals(5, l.getEnhedPrKgPrDoegnLet(), 0.001d);
    	assertEquals(10, l.getEnhedPrKgPrDoegnNormal(), 0.001d);
    	assertEquals(15, l.getEnhedPrKgPrDoegnTung(), 0.001d);
    	assertEquals("gr", l.getEnhed());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void opretLaegemiddelTC6() {
    	Laegemiddel l = c.opretLaegemiddel("Testiphenyl", 5, 10, 15, "");
    	
    	assertEquals("Testiphenyl", l.getNavn());
    	assertEquals(5, l.getEnhedPrKgPrDoegnLet(), 0.001d);
    	assertEquals(10, l.getEnhedPrKgPrDoegnNormal(), 0.001d);
    	assertEquals(15, l.getEnhedPrKgPrDoegnTung(), 0.001d);
    	assertEquals("", l.getEnhed());
    }

}
