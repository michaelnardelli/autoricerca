import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class hello {
    public static void main(String[] args) {
        try {
            try (Scanner sc = new Scanner(System.in)) {
                Robot robot = new Robot();
            
                // Stampa un messaggio di benvenuto
                System.out.println("Questo programma esegue una ricerca su Google");
                System.out.println("Premi INVIO per continuare...");
    
                
                // Chiedi all'utente di inserire cosa vuole cercare
                System.out.print("Inserisci cosa vuoi cercare: ");
                String tmpcerca = sc.nextLine(); // Leggi la stringa inserita dall'utente
    
                // Esegui la ricerca
                ricerca(robot, 1403, 180, tmpcerca, 1548, 169); 
                robot.delay(6000);
                filtro(robot, 1505, 345, 1514, 397, 1430, 188);
                // Stampa un messaggio di uscita
                System.out.println("Ricerca completata!");
            }
            

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    // Metodo per eseguire la ricerca
    public static void ricerca(Robot robot, int initialX, int initialY, String searchText, int finalX, int finalY) {
        try {
            // Sposta il mouse alla posizione iniziale
            System.out.println("Spostando il mouse alla posizione iniziale (" + initialX + ", " + initialY + ")");
            robot.mouseMove(initialX, initialY);
            robot.delay(1000);

            // Clicca il mouse nella posizione iniziale
            System.out.println("Cliccando il mouse nella posizione (" + initialX + ", " + initialY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);

            // Scrive il testo nella casella di testo
            System.out.println("Scrivendo il testo: " + searchText);
            typeString(robot, searchText);

            // Ritardo dopo la scrittura della stringa
            robot.delay(1000);

            // Sposta il mouse alla nuova posizione
            System.out.println("Spostando il mouse alla nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mouseMove(finalX, finalY);
            robot.delay(1000);

            // Clicca il mouse nella nuova posizione
            System.out.println("Cliccando il mouse nella nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        } catch (Exception e) {
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
            } catch (IllegalArgumentException ex) {
                // Se non è possibile trovare il codice chiave esteso, prova con il carattere diretto
                robot.keyPress(c);
                robot.delay(50);  // Assicurati che il tasto sia premuto abbastanza a lungo
                robot.keyRelease(c);
                robot.delay(50);  // Ritardo tra le pressioni dei tasti
            }
        }
    }
    private static void filtro(Robot robot, int initialX, int initialY, int finalX, int finalY , int ordinex, int ordiney) {
        try {
            // Sposta il mouse alla posizione iniziale
            System.out.println("Spostando il mouse alla posizione iniziale (" + initialX + ", " + initialY + ")");
            robot.mouseMove(initialX, initialY);
            robot.delay(1000);

            // Clicca il mouse nella posizione iniziale
            System.out.println("Cliccando il mouse nella posizione (" + initialX + ", " + initialY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(1000);

            // Sposta il mouse alla nuova posizione
            System.out.println("Spostando il mouse alla nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mouseMove(finalX, finalY);
            robot.delay(1000);

            // Clicca il mouse nella nuova posizione
            System.out.println("Cliccando il mouse nella nuova posizione (" + finalX + ", " + finalY + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

robot.delay(1000);
            System.out.println("Spostando il mouse alla nuova posizione (" + ordinex + ", " + ordiney + ")");
            robot.mouseMove(ordinex, ordiney);
            robot.delay(1000);

            System.out.println("Cliccando il mouse nella nuova posizione (" + ordinex + ", " + ordiney + ")");
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(200); // Ritardo per garantire che il clic sia registrato
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
