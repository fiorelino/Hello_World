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
		testAllCiphers();
		tellYourName();
        tellTimeToMeet();
		System.out.println("Selamat "+timeDependantGreeting());
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

    public static void tellTimeToMeet() {
        byte buffer[] = new byte[80];  // Zeichenpuffer
        String time;
        int read;
        System.out.print("Please enter time to meet me: ");
        try {
            read = System.in.read(buffer, 0, 80);
            time = new String(buffer, 0, read - 1);
            System.out.println("Ok At " + time + " you will meet me");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String timeDependantGreeting() {
        Calendar cal = Calendar.getInstance();
        cal.getTime();
        int hours;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println( "Sekarang ini jam " + sdf.format(cal.getTime()) );
        hours = cal.getTime().getHours() ;
        if (hours < 5) return "Subuh";
        if (hours < 12) return "Pagi";
        if (hours < 15) return "Siang";
        if (hours < 18) return "Sore";
        if (hours < 23) return "Malam";
        return "Tidur";
    }
}
