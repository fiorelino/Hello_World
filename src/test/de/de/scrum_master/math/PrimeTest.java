package de.de.scrum_master.math;

import org.junit.Test;
import static org.junit.Assert.*;

public class PrimeTest {
	@Test
	public void testIsPrime() throws Exception {
		assertTrue(Prime.isPrime(2));
		assertTrue(Prime.isPrime(3));
		assertTrue(Prime.isPrime(5));
		assertTrue(Prime.isPrime(7));
		assertTrue(Prime.isPrime(5059));
		assertTrue(Prime.isPrime(7919));
		assertTrue(Prime.isPrime(999983));
		assertTrue(Prime.isPrime(987643213));
	}

	@Test
	public void testIsNotPrime() throws Exception {
		assertFalse(Prime.isPrime(1));
		assertFalse(Prime.isPrime(4));
		assertFalse(Prime.isPrime(6));
		assertFalse(Prime.isPrime(17*19));
		assertFalse(Prime.isPrime(999999999));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentZero() throws Exception {
		Prime.isPrime(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentNegative() throws Exception {
		Prime.isPrime(-1);
	}
}
