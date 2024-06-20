package autoricerca.src.main.java.com.example;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Point; // Import the Point class

public class Main {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            Scanner sc = new Scanner(System.in);
            Letturadati letturaDati = new Letturadati();
            System.out.println(letturaDati.lettura()); // Call lettura to initialize datiMap
            System.out.println(letturaDati.toString());
            // Welcome message and wait for user input
            System.out.println("Questo programma esegue una ricerca su Google");
            System.out.println("Premi INVIO per continuare...");
            sc.nextLine();

            // Ask user for search term
            
            // Perform search operation
            Ricerca ricercaGoogle = new Ricerca();
            // Instantiate Letturadati and read the data into a HashMap
       
            HashMap<String, String> datiMap = letturaDati.lettura();
            
            // Assuming ricercaGoogle is an instance of a class that has the eseguiRicerca method
            // and robot, searchText are previously defined in your code
            
            int pause = Integer.parseInt(datiMap.getOrDefault("pause", "1000").replaceAll(";", "").trim()); // Remove semicolon and trim spaces before parsing
            String testo = datiMap.get("testo"); // Retrieve 'testo' // Default value is 1000
            String clik = datiMap.get("clik"); // Retrieve 'clik' // Default value is 1000

            // Find the icon on the screen
            IconFinder iconFinder = new IconFinder();
            Point iconPosition = .findIcon("icon"); // Declare and initialize iconPosition
            
            // Now use these values in your method call
            int posx = iconPosition.x;
            int posy = iconPosition.y;
            ricercaGoogle.eseguiRicerca(robot, posx, posy, testo, pause, clik);

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
