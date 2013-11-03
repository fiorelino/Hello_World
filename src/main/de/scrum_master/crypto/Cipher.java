package de.scrum_master.crypto;

public interface Cipher {
	public String encrypt(String clearText);
	public String decrypt(String cipherText);
}
