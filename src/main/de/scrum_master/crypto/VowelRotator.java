package de.scrum_master.crypto;

public class VowelRotator implements Cipher {
	private static final Cipher delegateCipher = new CharacterMixer("aeioAEIOU", "eioaEIOUA");
	
	@Override
	public String encrypt(String clearText) {
		return delegateCipher.encrypt(clearText);
	}

	@Override
	public String decrypt(String cipherText) {
		return delegateCipher.decrypt(cipherText);
	}
}
