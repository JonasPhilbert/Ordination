package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;

public class ControllerOpretPNTest {

	Controller c;
	Patient p;
	Laegemiddel l;
	
	LocalDate startDen; 
	
	@Before
	public void setUp() {
		c = Controller.getController();
		p = new Patient("0123456789", "Peter Justesen", 85.3);
		l = new Laegemiddel("Testunitamilin", 10, 20, 30, "ug");
		
		startDen = LocalDate.of(2000, 01, 01);
	}
	
	@Test
	public void opretPNOrdinationTC1() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		PN pn = c.opretPNOrdination(startDen, slutDen, p, l, 0);
		assertNotNull(pn);
		assertEquals(startDen, pn.getStartDen());
		assertEquals(slutDen, pn.getSlutDen());
		assertEquals(l, pn.getLaegemiddel());
		assertEquals(0, pn.getAntalEnheder(), 0.001d);
	}
	
	@Test
	public void opretPNOrdinationTC2() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		PN pn = c.opretPNOrdination(startDen, slutDen, p, l, 0);
		assertNotNull(pn);
		assertEquals(startDen, pn.getStartDen());
		assertEquals(slutDen, pn.getSlutDen());
		assertEquals(l, pn.getLaegemiddel());
		assertEquals(0, pn.getAntalEnheder(), 0.001d);
	}

}
