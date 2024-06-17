
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.AWTException;
public class Ricerca {

    public void eseguiRicerca(Robot robot, int initialX, int initialY, String searchText, int finalX, int finalY) {
        try {
            // Move mouse to initial position
            System.out.println("Spostando il mouse alla posizione iniziale (" + initialX + ", " + initialY + ")");
            robot.mouseMove(initialX, initialY);
            robot.delay(1000);
    
            // Click at initial position
            System.out.println("Cliccando il mouse nella posizione (" + initialX + ", " + initialY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Delay to ensure click is registered
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);
    
            // Type the search text
            System.out.println("Scrivendo il testo: " + searchText);
            typeString(robot, searchText);
            robot.delay(1000);
    
            // Move mouse to final position
            System.out.println("Spostando il mouse alla nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mouseMove(finalX, finalY);
            robot.delay(1000);
    
            // Click at final position
            System.out.println("Cliccando il mouse nella nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Delay to ensure click is registered
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        } finally {
            // Add the missing closing brace here
        }
    }



    private void typeString(Robot robot, String text) {
        for (char c : text.toCharArray()) {
            try {
                int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (keyCode == KeyEvent.VK_UNDEFINED) {
                    throw new RuntimeException(
                            "Codice chiave non trovato per il carattere '" + c + "'");
                }
                robot.keyPress(keyCode);
                robot.delay(50);  // Ensure key press is long enough
                robot.keyRelease(keyCode);
                robot.delay(50);  // Delay between key presses
            } catch (IllegalArgumentException ex) {
                // If extended key code not found, try direct character
                robot.keyPress(c);
                robot.delay(50);  // Ensure key press is long enough
                robot.keyRelease(c);
                robot.delay(50);  // Delay between key presses
            }
        }
    }
}
