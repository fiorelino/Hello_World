package de.anoraganingrum.helloworld;

import de.scrum_master.crypto.CesarCipher;
import de.scrum_master.crypto.CharacterMixer;
import de.scrum_master.crypto.Cipher;
import de.scrum_master.crypto.VowelRotator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HelloWorld {
	public static void main(String[] args) throws IOException {
		sayHello("master");
		testAllCiphers();
		tellYourName();
		tellTimeToMeet();
		System.out.println("Selamat " + timeDependantGreeting());
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

	public static void tellTimeToMeet() throws IOException {
		byte buffer[] = new byte[80];
		String time;
		int read;
		System.out.print("Please enter time [hh:mm] to meet me: ");
		read = System.in.read(buffer, 0, 80);
		time = parseTime(new String(buffer, 0, read - 1));
		System.out.println("OK, at " + time + " you will meet me.");
	}

	public static String parseTime(String time) throws IllegalArgumentException {
		if (time == null)
			throw new IllegalArgumentException("parameter must be != null!");

		time = time.trim();
		int timeLength = time.length();

		if (timeLength == 0)
			throw new IllegalArgumentException("parameter must not be empty!");

		if (timeLength < 4)
			throw new IllegalArgumentException("parameter should have format hh:mm");

		if (timeLength > 5)
			throw new IllegalArgumentException("parameter should have format hh:mm");

		String[] timeText = time.split(":");
		String hoursText = timeText[0];
		String minutesText = timeText[1];

		if (minutesText.length() == 1)
			throw new IllegalArgumentException("minutes-parameter should have format mm");

		int hours = Integer.parseInt(hoursText);
		int minutes = Integer.parseInt(minutesText);
		int hoursLength = Integer.toString(hours).length();

		if (hours != Math.abs(hours) || minutes != Math.abs(minutes))
			throw new IllegalArgumentException("illegal - character");

		if (hoursLength == 1)
			hoursText = "0" + Integer.toString(hours);

		time = hoursText + ":" + minutesText;
		if (hours >= 24)
			throw new IllegalArgumentException("hours must be < 24");
		if (minutes >= 60)
			throw new IllegalArgumentException("minutes must be < 60");

		return time;
	}

	public static String timeDependantGreeting() {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		int hours;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println("Sekarang ini jam " + sdf.format(cal.getTime()));
		hours = cal.getTime().getHours();
		if (hours < 5) return "Subuh";
		if (hours < 12) return "Pagi";
		if (hours < 15) return "Siang";
		if (hours < 18) return "Sore";
		if (hours < 23) return "Malam";
		return "Tidur";
	}
}
