package de.anoraganingrum.helloworld;

import de.scrum_master.crypto.CesarCipher;
import de.scrum_master.crypto.CharacterMixer;
import de.scrum_master.crypto.Cipher;
import de.scrum_master.crypto.VowelRotator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HelloWorld {
	public static void main(String[] args) {
		sayHello("master");
		String clearText = "Alexander Kriegisch ÄÖÜ äöü ß éèê";
		testCipher(new VowelRotator(), clearText);
		testCipher(new CharacterMixer("aeioAEIOU", "eioaEIOUA"), clearText);
		testCipher(new CesarCipher(), clearText);
		testCipher(
			new CharacterMixer(
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",
				"fghijklmnopqrstuvwxyzabcdeFGHIJKLMNOPQRSTUVWXYZABCDE"
			),
			clearText
		);
		testCipher(
			new CharacterMixer(
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜäöüßáàâÁÀÂéèêÉÈÊíìîÍÌÎóòôÓÒÔúùûÚÙÛ",
				"vjÒJßKíìaêBÙÄketûgDpOîoClxÊÚLIRfÁGÓéäuMycrAèÛÔQnbUwVÀúÉdáXâÍEZSWÈôühYzóöPàiÖHÌÎùqTFmsNÜÂò"
			),
			clearText
		);
		tellYourName();
		System.out.println(timeDependantGreeting());
	}

	public static void sayHello(String name) {
		System.out.println("Hello " + name + "!");
	}

	private static void testCipher(Cipher cipher, String clearText) {
		System.out.printf("Testing cipher: %s%n", cipher);
		System.out.printf("  Clear text:     %s%n", clearText);
		String cipherText = cipher.encrypt(clearText);
		System.out.printf("  Cipher text:    %s%n", cipherText);
		System.out.printf("  Decrypted text: %s%n", cipher.decrypt(cipherText));
		System.out.printf("Test result: %s%n", clearText.equals(cipher.decrypt(cipherText)));
	}

	public static void tellYourName() {
		byte buffer[] = new byte[80];  // Zeichenpuffer
		String input;
		int read;
		System.out.print("Please enter your name: ");
		try {
			read = System.in.read(buffer, 0, 80);
			input = new String(buffer, 0, read - 1);
			System.out.println("Hi " + input + "!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String timeDependantGreeting() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		System.out.println( "Sekarang ini jam " + sdf.format(cal.getTime()) );

		if (cal.getTime().getHours() < 12) {
			return "Selamat Pagi ";
		} else
			return "Selamat Sore ";
	}
}
