package de.scrum_master.crypto;

import org.junit.Test;
import static junit.framework.Assert.*;

public class CesarCipherTest {
    private final CesarCipher cipher = new CesarCipher();

    @Test
    public void testEncrypt() throws Exception {
        assertEquals("fwzr", cipher.encrypt("arum"));
        assertEquals("fwzr ÜgjsE", cipher.encrypt("arum ÜbenZ"));
    }

    @Test
    public void testDecrypt() throws Exception {
        assertEquals("arum", cipher.decrypt("fwzr"));
        assertEquals("arum ÜbenZ", cipher.decrypt("fwzr ÜgjsE"));
    }
}
