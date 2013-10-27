package de.anoraganingrum.helloworld;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) {
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
            try {
                // Einlesen der Zeichen
                read = System.in.read(buffer, 0, 80);
                // Umwandeln des Pufferinhaltes in einen String
                input = new String(buffer, 0, read);
                // Ausgabe der eingelesenen Zeichen
                System.out.print(input);
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        } while(! input.equals("exit"+System.getProperty("line.separator")));
        System.out.println(
                "Thank you very much for using this program");
    }
}
