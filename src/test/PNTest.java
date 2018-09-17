package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ordination.Laegemiddel;
import ordination.PN;

public class PNTest {

	Laegemiddel lm;
	
	@Before
	public void setUp() {
		lm = new Laegemiddel("Testimol", 10, 20, 30, "ml");
	}
	
	// samletDosis()
	@Test
	public void samletDosisTC1() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
		assertEquals(0, pn.samletDosis(), 0.001d);
	}
	
	@Test
	public void samletDosisTC2() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(0, pn.samletDosis(), 0.001d);
	}
	
	@Test
	public void samletDosisTC3() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		assertEquals(0, pn.samletDosis(), 0.001d);
	}
	
	@Test
	public void samletDosisTC4() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(10, pn.samletDosis(), 0.001d);
	}
	
	@Test
	public void samletDosisTC5() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(20, pn.samletDosis(), 0.001d);
	}
	
	@Test
	public void samletDosisTC6() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		for (int i = 0; i < 10; i++) {
			pn.givDosis(LocalDate.of(2000, 01, 03));
		}
		assertEquals(100, pn.samletDosis(), 0.001d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void samletDosisTC7() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, -1d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(-10, pn.samletDosis(), 0.001d);
	}
	
	// doegnDosis()
	@Test
	public void doegnDosisTC1() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
		assertEquals(0d, pn.doegnDosis(), 0.001d);
	}
	
	@Test
	public void doegnDosisTC2() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 0d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(0d, pn.doegnDosis(), 0.001d);
	}
	
	@Test
	public void doegnDosisTC3() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		assertEquals(0d, pn.doegnDosis(), 0.001d);
	}
	
	@Test
	public void doegnDosisTC4() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(2d, pn.doegnDosis(), 0.001d);
	}
	
	@Test
	public void doegnDosisTC5() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(4d, pn.doegnDosis(), 0.001d);
	}
	
	@Test
	public void doegnDosisTC6() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, 10d);
		for (int i = 0; i < 10; i ++) {
			pn.givDosis(LocalDate.of(2000, 01, 03));
		}
		assertEquals(20d, pn.doegnDosis(), 0.001d);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void doegnDosisTC7() {
		PN pn = new PN(LocalDate.of(2000, 01, 01), LocalDate.of(2000, 01, 05), lm, -1d);
		pn.givDosis(LocalDate.of(2000, 01, 03));
		assertEquals(2d, pn.doegnDosis(), 0.001d);
	}

}
