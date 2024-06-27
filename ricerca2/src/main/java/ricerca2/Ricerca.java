package ricerca2;
import java.awt.event.InputEvent;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.AWTException;

public class Ricerca {
  private static int ClikEvent = InputEvent.BUTTON1_DOWN_MASK;

    public void eseguiRicerca(Robot robot, int initialX, int initialY, String searchText, int pausa, String clik) {

        // Move mouse to initial position
        if (clik.equals("s")) {
            ClikEvent = InputEvent.BUTTON1_DOWN_MASK;
        } else if (clik.equals("d")) {
            ClikEvent = InputEvent.BUTTON3_DOWN_MASK;
        } else {
            // throw new IllegalArgumentException("Il valore di clik deve essere 's' o
            // 'd'");
            ClikEvent = -1;
        }
        if (initialX != -1 || initialY != -1) {
           
            robot.mouseMove(initialX, initialY);
        }

        // Click at initial position
      

        if (ClikEvent != -1) {
            robot.mousePress(ClikEvent);
            // Delay to ensure click is registered
            robot.mouseRelease(ClikEvent);

        }
        if (!searchText.equals("")) {
         
            typeString(robot, searchText);

        }
        if (pausa != -1) {
            robot.delay(pausa);
        }
    }

    private void typeString(Robot robot, String text) {
        int keyCode = 0;
        for(int i=0; i<2; i++){
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    
        }
       
        for (char c : text.toCharArray()) {
            try {
                keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                if (keyCode == KeyEvent.VK_UNDEFINED) {
                    throw new RuntimeException(
                            "Codice chiave non trovato per il carattere '" + c + "'");
                }
 


                robot.keyPress(keyCode);
                // robot.delay(50); // Ensure key press is long enough
                robot.keyRelease(keyCode);
                // robot.delay(50); // Delay between key presses
            } catch (IllegalArgumentException ex) {
                System.out.println("Carattere non supportato: " + c);  
            }
        }
    }
}
