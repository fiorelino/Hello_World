package de.scrum_master.crypto;

import org.junit.Test;
import static junit.framework.Assert.*;

public class CesarCipherTest {
    private final CesarCipher cipher = new CesarCipher();

    @Test
    public void testEncrypt() throws Exception {
        assertEquals(cipher.encrypt("arum"), "fwzr");
        assertEquals(cipher.encrypt("arumÜbenZ "), "fwzrÜgjsE ");
    }

    @Test
    public void testDecrypt() throws Exception {
        assertEquals(cipher.decrypt("fwzr"), "arum");
        assertEquals(cipher.decrypt("fwzrÜgjsE "),"arumÜbenZ ");
    }
}
