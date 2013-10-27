package de.scrum_master.crypto;

public class CesarCipher implements Cipher {
	private static final int OFFSET = 5;

	@Override
	public String encrypt(String clearText) {
		char[] characters = new char[clearText.length()];
		clearText.getChars(0, clearText.length(), characters, 0);
		int i = 0;
		for (char character : characters) {
			char replacementCharacter;
			if (character >= 'a' && character <= 'z') {
				replacementCharacter = (char) (character + OFFSET);
				if (replacementCharacter > 'z')
					replacementCharacter -= 'z' - 'a';
			}
			else if (character >= 'A' && character <= 'Z') {
				replacementCharacter = (char) (character + OFFSET);
				if (replacementCharacter > 'Z')
					replacementCharacter -= 'Z' - 'A';
			} else {
				replacementCharacter = character;
			}
			characters[i++] = replacementCharacter;
		}
		return new String(characters);
	}

	@Override
	public String decrypt(String cipherText) {
		char[] characters = new char[cipherText.length()];
		cipherText.getChars(0, cipherText.length(), characters, 0);
		int i = 0;
		for (char character : characters) {
			char replacementCharacter;
			if (character >= 'a' && character <= 'z') {
				replacementCharacter = (char) (character - OFFSET);
				if (replacementCharacter < 'a')
					replacementCharacter += 'z' - 'a';
			}
			else if (character >= 'A' && character <= 'Z') {
				replacementCharacter = (char) (character - OFFSET);
				if (replacementCharacter < 'A')
					replacementCharacter += 'Z' - 'A';
			} else {
				replacementCharacter = character;
			}
			characters[i++] = replacementCharacter;
		}
		return new String(characters);
	}
}
