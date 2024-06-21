package ricerca2;
import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
             Robot robot = new Robot();
            Scanner sc = new Scanner(System.in);
            Letturadati letturaDati = new Letturadati();
            List<Map<String, String>> listOfDatiMaps = letturaDati.lettura(); // Get the list of maps
            System.out.println(listOfDatiMaps); // Print the list to verify its content

            // Welcome message and wait for user input
          

            // Iterate over the list of maps
            for (Map<String, String> datiMap : listOfDatiMaps) {
               
                
                // Assuming ricercaGoogle and robot are already defined
                System.out.println(letturaDati.lettura()); // Call lettura to initialize datiMap
                System.out.println(letturaDati.toString());
                int posx = Integer.parseInt(datiMap.get("posx").replaceAll(";", "").trim());
                int posy = Integer.parseInt(datiMap.get("posy").replaceAll(";", "").trim());
                int pause = Integer.parseInt(datiMap.getOrDefault("pause", "1000").replaceAll(";", "").trim());
                String testo = datiMap.get("testo");
                String clik = datiMap.get("clik");
                Ricerca ricerca= new Ricerca();
                ricerca.eseguiRicerca(robot, posx, posy, testo, pause, clik);
                robot.delay(6000);
                
            // Instantiate Letturadati and read the data into a HashMap
       
         
            // Assuming ricercaGoogle is an instance of a class that has the eseguiRicerca method
            // and robot, searchText are previously defined in your code
            
    
            // Now use these values in your method call


            // Delay before next action
            robot.delay(6000);

            // Perform filter operation
            Filtro filtroGoogle = new Filtro();
            filtroGoogle.eseguiFiltro(robot, 1505, 345, 1514, 397, 1430, 188);
            // Print completion message
            System.out.println("Ricerca completata!"
            
            );
    // Assuming Filtro and its method calls are defined similarly
            }
            // Perform search operation
           

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
