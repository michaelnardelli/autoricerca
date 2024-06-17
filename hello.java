import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class hello {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();

            // Sposta il mouse alle coordinate specificate (x, y)
            int x = 1403; // Coordinata X
            int y = 180; // Coordinata Y
            System.out.println("Spostando il mouse alla posizione iniziale (" + x + ", " + y + ")");
            robot.mouseMove(x, y);

            // Ritardo per dare al sistema un po' di tempo per elaborare
            robot.delay(1000);

            // Clicca il mouse nella posizione corrente (clic sinistro)
            System.out.println("Cliccando il mouse nella posizione (" + x + ", " + y + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // Ritardo per dare al sistema un po' di tempo per elaborare
            robot.delay(1000);

            // Scrivi la stringa nella casella di testo
            String text = "Hello, world!";
            System.out.println("Scrivendo il testo: " + text);
            typeString(robot, text);

            // Ritardo dopo la scrittura della stringa
            robot.delay(1000);

            // Sposta il mouse alle nuove coordinate (x2, y2)
            int x2 = 1548; // Coordinata X
            int y2 = 169; // Coordinata Y
            System.out.println("Spostando il mouse alla nuova posizione (" + x2 + ", " + y2 + ")");
            robot.mouseMove(x2, y2);

            // Clicca il mouse nella nuova posizione (clic sinistro)
            System.out.println("Cliccando il mouse nella nuova posizione (" + x2 + ", " + y2 + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // Metodo di supporto per scrivere una stringa utilizzando Robot
    public static void typeString(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            try {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (keyCode == KeyEvent.VK_UNDEFINED) {
                    throw new RuntimeException(
                            "Codice chiave non trovato per il carattere '" + c + "'");
                }
                robot.keyPress(keyCode);
                robot.delay(50);  // Assicurati che il tasto sia premuto abbastanza a lungo
                robot.keyRelease(keyCode);
                robot.delay(50);  // Ritardo tra le pressioni dei tasti
            } catch (IllegalArgumentException e) {
                // Se non è possibile trovare il codice chiave esteso, prova con il carattere diretto
                robot.keyPress(c);
                robot.delay(50);  // Assicurati che il tasto sia premuto abbastanza a lungo
                robot.keyRelease(c);
                robot.delay(50);  // Ritardo tra le pressioni dei tasti
            }
        }
    }
}
