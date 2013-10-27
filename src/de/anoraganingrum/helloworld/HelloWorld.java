package de.anoraganingrum.helloworld;

import java.io.IOException;

public class HelloWorld {
	public static void main(String[] args) {
		sayHello("master");
		String clearText = "Alexander Kriegisch";
		System.out.println(clearText);
		System.out.println(encrypt(clearText));
		System.out.println(decrypt(encrypt(clearText)));
		System.exit(0);
		tellYourName();
	}

	public static void sayHello(String name) {
		System.out.println("Hello " + name + "!");
	}

	public static void tellYourName() {
		byte buffer[] = new byte[80];  // Zeichenpuffer
		String input = "";
		int read;
		do {
			System.out.print("Please enter your name: ");
			try {
				// Einlesen der Zeichen
				read = System.in.read(buffer, 0, 80);
				// Umwandeln des Pufferinhaltes in einen String
				input = new String(buffer, 0, read);
				// Ausgabe der eingelesenen Zeichen
				System.out.print(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!input.equals("exit" + System.getProperty("line.separator")));
		System.out.println(
			"Thank you very much for using this program");
	}

	public static String encrypt(String clearText) {
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
			characters[i] = replacementCharacter;
			i++;
		}
		return new String(characters);
	}

	public static String decrypt(String cipherText) {
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
			characters[i] = replacementCharacter;
			i++;
		}
		return new String(characters);
	}
}
