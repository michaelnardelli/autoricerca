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
            int posx=-1;
            int posy=-1;
            int pause=-1;
            String testo = "";
            String clik=null;

             Robot robot = new Robot();
            Scanner sc = new Scanner(System.in);
            Letturadati letturaDati = new Letturadati();
            List<Map<String, String>> listOfDatiMaps = letturaDati.lettura(); // Get the list of maps
            System.out.println(listOfDatiMaps); // Print the list to verify its content

            // Welcome message and wait for user input
          

            // Iterate over the list of maps
            for (Map<String, String> datiMap : listOfDatiMaps) {
                posx=-1;
                posy=-1;
                pause=-1;
                testo = "";
                clik="";
                
                
                // Assuming ricercaGoogle and robot are already defined
                System.out.println(letturaDati.lettura()); // Call lettura to initialize datiMap
                System.out.println(letturaDati.toString());

            if(datiMap.containsKey("posx"))
                {posx = Integer.parseInt(datiMap.get("posx").replaceAll(";", "").trim());} 
            if (datiMap.containsKey("posy"))
                {posy = Integer.parseInt(datiMap.get("posy").replaceAll(";", "").trim());} 
            if (datiMap.containsKey("pause"))
                {pause = Integer.parseInt(datiMap.get("pause").replaceAll(";", "").trim());}
            if (datiMap.containsKey("testo"))
                {testo = datiMap.get("testo").replaceAll(";", "").trim();}   
            if (datiMap.containsKey("clik"))  
                {clik = datiMap.get("clik").replaceAll(";", "").trim();}  
           


            

                Ricerca ricerca= new Ricerca();
                ricerca.eseguiRicerca(robot, posx, posy, testo, pause, clik);
                //robot.delay(pause);
                
            
           

            // Perform filter operation
            
            // Print completion message
            System.out.println("Ricerca completata!"
            
            );
    // Assuming Filtro and its method calls are defined similarly
            }
            // Perform search operation
           

            // Perform filter operation
           

            // Close resources
            sc.close();

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
