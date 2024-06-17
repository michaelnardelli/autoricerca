
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Filtro {

    public void eseguiFiltro(Robot robot, int initialX, int initialY, int finalX, int finalY, int ordinex, int ordiney) {
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

        // Move mouse to final position
        System.out.println("Spostando il mouse alla nuova posizione (" + finalX + ", " + finalY + ")");
        robot.mouseMove(finalX, finalY);
        robot.delay(1000);

        // Click at final position
        System.out.println("Cliccando il mouse nella nuova posizione (" + finalX + ", " + finalY + ")");
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200); // Delay to ensure click is registered
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);

        // Move mouse to additional position
        System.out.println("Spostando il mouse alla nuova posizione (" + ordinex + ", " + ordiney + ")");
        robot.mouseMove(ordinex, ordiney);
        robot.delay(1000);

        // Click at additional position
        System.out.println("Cliccando il mouse nella nuova posizione (" + ordinex + ", " + ordiney + ")");
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200); // Delay to ensure click is registered
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
