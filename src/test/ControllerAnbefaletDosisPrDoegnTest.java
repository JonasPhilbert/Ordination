package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.Controller;
import ordination.Laegemiddel;
import ordination.Patient;

public class ControllerAnbefaletDosisPrDoegnTest {

	Controller c;
	Laegemiddel l;
	
	@Before
	public void setUp() throws Exception {
		c = Controller.getController();
		l = new Laegemiddel("Testamol", 10, 20, 30, "mg");
	}

	@Test
	public void anbefaldetDosisPrDoegnTC1() {
		Patient p = new Patient("0123456789", "Peter Justesen", 20);
		assertEquals(200, c.anbefaletDosisPrDoegn(p, l), 0.001d);
	}
	
	@Test
	public void anbefaldetDosisPrDoegnTC2() {
		Patient p = new Patient("0123456789", "Peter Justesen", 75);
		assertEquals(1500, c.anbefaletDosisPrDoegn(p, l), 0.001d);
	}
	
	@Test
	public void anbefaldetDosisPrDoegnTC3() {
		Patient p = new Patient("0123456789", "Peter Justesen", 150);
		assertEquals(4500, c.anbefaletDosisPrDoegn(p, l), 0.001d);
	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void anbefaldetDosisPrDoegnTC4() {
//		Patient p = new Patient("0123456789", "Peter Justesen", 0);
//		assertEquals(0, c.anbefaletDosisPrDoegn(p, l), 0.001d);
//	}
	
//	@Test(expected = IllegalArgumentException.class)
//	public void anbefaldetDosisPrDoegnTC5() {
//		Patient p = new Patient("0123456789", "Peter Justesen", -1);
//		assertEquals(0, c.anbefaletDosisPrDoegn(p, l), 0.001d);
//	}
	
	@Test(expected = IllegalArgumentException.class)
	public void anbefaldetDosisPrDoegnTC6() {
		Patient p = new Patient("0123456789", "Peter Justesen", 20);
		assertEquals(200, c.anbefaletDosisPrDoegn(p, null), 0.001d);
	}

}
