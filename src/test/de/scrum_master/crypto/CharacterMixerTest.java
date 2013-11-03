package de.scrum_master.crypto;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterMixerTest {
    private final CharacterMixer cipher = new CharacterMixer("arum1234", "1234arum");

    @Test
    public void testEncrypt() throws Exception {
        assertEquals("1234", cipher.encrypt("arum"));
        assertEquals("2346", cipher.encrypt("rum6"));
        assertEquals("b123", cipher.encrypt("baru"));
        assertEquals("4i21", cipher.encrypt("mira"));
        assertEquals("lend", cipher.encrypt("lend"));
        assertEquals("k1sih1n deh", cipher.encrypt("kasihan deh"));
        assertEquals("1234 arum", cipher.encrypt("arum 1234"));
    }

    @Test
    public void testDecrypt() throws Exception {
        assertEquals("arum", cipher.decrypt("1234"));
        assertEquals("rum6", cipher.decrypt("2346"));
        assertEquals("baru", cipher.decrypt("b123"));
        assertEquals("mira", cipher.decrypt("4i21"));
        assertEquals("lend", cipher.decrypt("lend"));
        assertEquals("kasihan deh", cipher.decrypt("k1sih1n deh"));
        assertEquals("arum 1234", cipher.decrypt("1234 arum"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullArguments() {
        new CharacterMixer(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSourceNull() {
        new CharacterMixer(null, "bla");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTargetNull() {
        new CharacterMixer("bla", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSourceEmpty() {
        new CharacterMixer(" ", "bla");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTargetEmpty() {
        new CharacterMixer("bla", " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArguments() {
        new CharacterMixer(" ", " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLengthArguments() {
        new CharacterMixer("ARU", "MURA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSourceNonBijective() {
        new CharacterMixer("ARUA", "MURA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonBijectiveArguments() {
        new CharacterMixer("ARUM", "MARA");
    }

    @Test(expected = IllegalArgumentException.class)
         public void testTargetNonBijective() {
        new CharacterMixer("ARUA", "MARA");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNonIdenticalArguments() {
        new CharacterMixer("Arum", "1234");
    }
}
