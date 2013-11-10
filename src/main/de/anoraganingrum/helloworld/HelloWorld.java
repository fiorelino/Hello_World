package de.anoraganingrum.helloworld;

import de.scrum_master.crypto.CesarCipher;
import de.scrum_master.crypto.CharacterMixer;
import de.scrum_master.crypto.Cipher;
import de.scrum_master.crypto.VowelRotator;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
	static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public static void main(String[] args) throws IOException, ParseException {
		sayHello("master");
		testAllCiphers();
		tellYourName();
		tellTimeToMeet();
	}

	public static void sayHello(String name) {
		System.out.println("Hello " + name + "!");
	}

	private static void testAllCiphers() {
		String clearText = "Alexander Kriegisch ÄÖÜ äöü ß éèê";
		testCipher(new VowelRotator(), clearText);
		testCipher(new CesarCipher(), clearText);
		testCipher(
			new CharacterMixer(
				"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜäöüßáàâÁÀÂéèêÉÈÊíìîÍÌÎóòôÓÒÔúùûÚÙÛ",
				"vjÒJßKíìaêBÙÄketûgDpOîoClxÊÚLIRfÁGÓéäuMycrAèÛÔQnbUwVÀúÉdáXâÍEZSWÈôühYzóöPàiÖHÌÎùqTFmsNÜÂò"
			),
			clearText
		);
	}

	private static void testCipher(Cipher cipher, String clearText) {
		String cipherText = cipher.encrypt(clearText);
		String decryptedText = cipher.decrypt(cipherText);
		System.out.printf("Testing cipher: %s%n", cipher.getClass().getSimpleName());
		System.out.printf("  Clear text:     %s%n", clearText);
		System.out.printf("  Cipher text:    %s%n", cipherText);
		System.out.printf("  Decrypted text: %s%n", decryptedText);
		System.out.printf("Test result: %s%n", clearText.equals(decryptedText));
	}

	public static void tellYourName() throws IOException {
		byte buffer[] = new byte[80];
		String input;
		int read;
		System.out.print("Please enter your name: ");
		read = System.in.read(buffer, 0, 80);
		input = new String(buffer, 0, read - 1);
		System.out.println("Hi " + input + "!");
	}

	public static void tellTimeToMeet() throws IOException, ParseException {
		byte buffer[] = new byte[80];
		Date time;
		int read;
		System.out.print("Please enter time [hh:mm] to meet me: ");
		read = System.in.read(buffer, 0, 80);
		time = parseTime(new String(buffer, 0, read - 1));
		String greeting = timeDependantGreeting(time);
		System.out.println("OK, at " + timeFormat.format(time) + " " + greeting + " you will meet me.");
	}

	public static Date parseTime(String time) throws ParseException {
		if (time == null)
			throw new ParseException("Unparseable date: null", 0);
		time = time.trim();
		if (!time.matches("[0-9][0-9]?:[0-9][0-9]"))
			throw new ParseException("Unparseable date: \"" + time + "\"", 0);
		timeFormat.setLenient(false);
		return timeFormat.parse(time);
	}

	public static String timeDependantGreeting(Date time) throws ParseException {
		int hours = time.getHours();
		if (hours < 5) return "Subuh";
		if (hours < 12) return "Pagi";
		if (hours < 15) return "Siang";
		if (hours < 18) return "Sore";
		if (hours < 23) return "Malam";
		return "Tidur";
	}
}
