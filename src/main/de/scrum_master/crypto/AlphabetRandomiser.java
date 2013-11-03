package de.scrum_master.crypto;

import java.util.Random;

public class AlphabetRandomiser {
	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜäöüßáàâÁÀÂéèêÉÈÊíìîÍÌÎóòôÓÒÔúùûÚÙÛ";
		final int alphabetLength = alphabet.length();
		char[] characters = new char[alphabetLength];
		alphabet.getChars(0, alphabetLength, characters, 0);
		int countPrinted = 0;
		Random random = new Random();
		while (countPrinted < alphabetLength) {
			int index = random.nextInt(alphabetLength);
			if (characters[index] != 0) {
				System.out.print(characters[index]);
				countPrinted++;
				characters[index] = 0;
			}
		}
		System.out.println();
	}
}
