package de.scrum_master.crypto;

import org.junit.Test;

import static junit.framework.Assert.*;

public class VowelRotatorTest {
	private final VowelRotator cipher = new VowelRotator();

	@Test
	public void testEncrypt() throws Exception {
		assertEquals("Elixendir", cipher.encrypt("Alexander"));
		assertEquals("EIOUAXYZeiouaxyz", cipher.encrypt("AEIOUXYZaeiouxyz"));
	}

	@Test
	public void testDecrypt() throws Exception {
		assertEquals("Alexander", cipher.decrypt("Elixendir"));
		assertEquals("AEIOUXYZaeiouxyz", cipher.decrypt("EIOUAXYZeiouaxyz"));
	}
}
