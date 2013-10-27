package de.scrum_master.crypto;

public class VowelRotator implements Cipher{
	@Override
	public String encrypt(String clearText) {
		char[] characters = new char[clearText.length()];
		clearText.getChars(0, clearText.length(), characters, 0);
		int i = 0;
		for (char character : characters) {
			char replacementCharacter = character;
			switch (character) {
				case 'a': replacementCharacter = 'e'; break;
				case 'e': replacementCharacter = 'i'; break;
				case 'i': replacementCharacter = 'o'; break;
				case 'o': replacementCharacter = 'u'; break;
				case 'u': replacementCharacter = 'a'; break;
				case 'A': replacementCharacter = 'E'; break;
				case 'E': replacementCharacter = 'I'; break;
				case 'I': replacementCharacter = 'O'; break;
				case 'O': replacementCharacter = 'U'; break;
				case 'U': replacementCharacter = 'A'; break;
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
			char replacementCharacter = character;
			switch (character) {
				case 'a': replacementCharacter = 'u'; break;
				case 'e': replacementCharacter = 'a'; break;
				case 'i': replacementCharacter = 'e'; break;
				case 'o': replacementCharacter = 'i'; break;
				case 'u': replacementCharacter = 'o'; break;
				case 'A': replacementCharacter = 'U'; break;
				case 'E': replacementCharacter = 'A'; break;
				case 'I': replacementCharacter = 'E'; break;
				case 'O': replacementCharacter = 'I'; break;
				case 'U': replacementCharacter = 'O'; break;
			}
			characters[i++] = replacementCharacter;
		}
		return new String(characters);
	}
}
