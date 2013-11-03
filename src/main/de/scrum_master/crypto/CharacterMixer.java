package de.scrum_master.crypto;

import java.util.HashMap;
import java.util.Map;

public class CharacterMixer implements Cipher {
	private final Map<Character, Character> encryptionMap = new HashMap<>();
	private final Map<Character, Character> decryptionMap = new HashMap<>();
	private final int mapSize;

	public CharacterMixer(String source, String target) {
		if (source == null || target == null)
			throw new IllegalArgumentException("parameters must be != null");
		source = source.trim();
		target = target.trim();
		mapSize = source.length();
		if (mapSize == 0 || target.length() == 0)
			throw new IllegalArgumentException("parameters must not be empty");
		if (mapSize != target.length())
			throw new IllegalArgumentException("parameters must have equal lengths");
		for (int i = 0; i < mapSize; i++) {
			encryptionMap.put(source.charAt(i), target.charAt(i));
			decryptionMap.put(target.charAt(i), source.charAt(i));
		}
		if (encryptionMap.size() != decryptionMap.size() || mapSize != encryptionMap.size())
			throw new IllegalArgumentException("character mapping must be bijective");
	}

	@Override
	public String encrypt(String clearText) {
		char[] characters = new char[clearText.length()];
		clearText.getChars(0, clearText.length(), characters, 0);
		int i = 0;
		for (char character : characters) {
			Character replacementCharacter = encryptionMap.get(character);
			characters[i++] = replacementCharacter == null ? character : replacementCharacter;
		}
		return new String(characters);
	}

	@Override
	public String decrypt(String cipherText) {
		char[] characters = new char[cipherText.length()];
		cipherText.getChars(0, cipherText.length(), characters, 0);
		int i = 0;
		for (char character : characters) {
			Character replacementCharacter = decryptionMap.get(character);
			characters[i++] = replacementCharacter == null ? character : replacementCharacter;
		}
		return new String(characters);
	}
}
