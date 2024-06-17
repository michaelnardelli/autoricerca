import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Scanner sc = new Scanner(System.in);
            Letturadati letturaDati = new Letturadati();
            letturaDati.lettura(); // Call lettura to initialize datiMap
            System.out.println(letturaDati.toString());
            // Welcome message and wait for user input
            System.out.println("Questo programma esegue una ricerca su Google");
            System.out.println("Premi INVIO per continuare...");
            sc.nextLine();

            // Ask user for search term
            System.out.print("Inserisci cosa vuoi cercare: ");
            String searchText = sc.nextLine();

            // Perform search operation
            Ricerca ricercaGoogle = new Ricerca();
            ricercaGoogle.eseguiRicerca(robot, 1403, 180, searchText, 1548, 169);

            // Delay before next action
            robot.delay(6000);

            // Perform filter operation
            Filtro filtroGoogle = new Filtro();
            filtroGoogle.eseguiFiltro(robot, 1505, 345, 1514, 397, 1430, 188);
            // Print completion message
            System.out.println("Ricerca completata!");

            // Close resources
            sc.close();

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
