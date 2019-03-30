package test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;

public class ControllerOpretOrdinationerTest {

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
	
	// PN
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
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationTC2() {
		LocalDate slutDen = LocalDate.of(2000, 01, 01);
		PN pn = c.opretPNOrdination(startDen, slutDen, p, l, 0);
		assertNotNull(pn);
		assertEquals(startDen, pn.getStartDen());
		assertEquals(slutDen, pn.getSlutDen());
		assertEquals(l, pn.getLaegemiddel());
		assertEquals(0, pn.getAntalEnheder(), 0.001d);
	}
	
	@Test
	public void opretPNOrdinationTC3() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		PN pn = c.opretPNOrdination(startDen, slutDen, p, l, 20);
		assertNotNull(pn);
		assertEquals(startDen, pn.getStartDen());
		assertEquals(slutDen, pn.getSlutDen());
		assertEquals(l, pn.getLaegemiddel());
		assertEquals(20, pn.getAntalEnheder(), 0.001d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationTC4() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		PN pn = c.opretPNOrdination(startDen, slutDen, null, l, 20);
		assertNotNull(pn);
		assertEquals(startDen, pn.getStartDen());
		assertEquals(slutDen, pn.getSlutDen());
		assertEquals(l, pn.getLaegemiddel());
		assertEquals(20, pn.getAntalEnheder(), 0.001d);
	}
	
	// DagligFast
	private boolean assertDoser(DagligFast df, double dose) {
		Dosis[] doser = df.getDoser();
		return doser[0].getAntal() == dose && doser[1].getAntal() == dose && doser[2].getAntal() == dose
				&& doser[3].getAntal() == dose;
	}
	
	@Test
	public void opretDagligFastOrdinationTC1() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, p, l, 5, 5, 5, 5);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, 5));
	}
	
	@Test
	public void opretDagligFastOrdinationTC2() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, p, l, 0, 0, 0, 0);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationTC3() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, p, l, -1, -1, -1, -1);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, -1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationTC4() {
		LocalDate slutDen = LocalDate.of(1999, 12, 31);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, p, l, 5, 5, 5, 5);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationTC5() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, null, l, 5, 5, 5, 5);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationTC6() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		DagligFast df = c.opretDagligFastOrdination(startDen, slutDen, p, null, 5, 5, 5, 5);
		
		assertNotNull(df);
		assertEquals(startDen, df.getStartDen());
		assertEquals(slutDen, df.getSlutDen());
		assertEquals(l, df.getLaegemiddel());
		assertTrue(assertDoser(df, 5));
	}
	
	// DagligSkaev
	private boolean assertSkaevDoser(DagligSkaev ds, LocalTime[] tider, double[] mængder) {
		boolean match = true;
		for (int i = 0; i < ds.getDoser().size(); i++) {
			Dosis d = ds.getDoser().get(i);
			if (d.getTid() != tider[i] || d.getAntal() != mængder[i]) {
				match = false;
			}
		}
		
		return match;
	}
	
	@Test
	public void opretDagligSkaevOrdinationTC1() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {};
		double[] doseMængder = new double[] {};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test
	public void opretDagligSkaevOrdinationTC2() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {LocalTime.of(12, 0)};
		double[] doseMængder = new double[] {5d};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test
	public void opretDagligSkaevOrdinationTC3() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {LocalTime.of(12, 0), LocalTime.of(16, 00)};
		double[] doseMængder = new double[] {5d, 10d};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationTC4() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {LocalTime.of(12, 0)};
		double[] doseMængder = new double[] {};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationTC5() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {};
		double[] doseMængder = new double[] {5d, 10d};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationTC6() {
		LocalDate slutDen = LocalDate.of(1999, 12, 31);
		LocalTime[] doseTider = new LocalTime[] {LocalTime.of(12, 00)};
		double[] doseMængder = new double[] {5d};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, p, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationTC7() {
		LocalDate slutDen = LocalDate.of(2000, 01, 05);
		LocalTime[] doseTider = new LocalTime[] {LocalTime.of(12, 00)};
		double[] doseMængder = new double[] {5d};
		DagligSkaev ds = c.opretDagligSkaevOrdination(startDen, slutDen, null, l, doseTider, doseMængder);
		
		assertNotNull(ds);
		assertEquals(startDen, ds.getStartDen());
		assertEquals(slutDen, ds.getSlutDen());
		assertEquals(l, ds.getLaegemiddel());
		assertTrue(assertSkaevDoser(ds, doseTider, doseMængder));
	}

}
