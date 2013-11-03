package de.scrum_master.crypto;

import org.junit.Test;

import static junit.framework.Assert.*;

public class VowelRotatorTest {
	private final VowelRotator cipher = new VowelRotator();

	@Test
	public void testEncrypt() throws Exception {
		assertEquals(cipher.encrypt("Alexander"), "Elixendir");
		assertEquals(cipher.encrypt("AEIOUXYZaeiouxyz"), "EIOUAXYZeiouaxyz");
	}

	@Test
	public void testDecrypt() throws Exception {
		assertEquals(cipher.decrypt("Elixendir"), "Alexander");
		assertEquals(cipher.decrypt("EIOUAXYZeiouaxyz"), "AEIOUXYZaeiouxyz");
	}
}
