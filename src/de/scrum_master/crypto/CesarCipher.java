package de.scrum_master.crypto;

public class CesarCipher implements Cipher {
	private static final Cipher delegateCipher =
		new CharacterMixer(
			"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
			"fghijklmnopqrstuvwxyzabcdeFGHIJKLMNOPQRSTUVWXYZABCDE"
		);

	@Override
	public String encrypt(String clearText) {
		return delegateCipher.encrypt(clearText);
	}

	@Override
	public String decrypt(String cipherText) {
		return delegateCipher.decrypt(cipherText);
	}
}
