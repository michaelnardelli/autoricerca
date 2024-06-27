package ricerca2;
import java.awt.AWTException;
import java.awt.Robot;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Main {

    public static void main(String[] args) {
        try {
            int posx=-1;
            int posy=-1;
            int pause=-1;
            String testo = "";
            String clik="";

             Robot robot = new Robot();
            Scanner sc = new Scanner(System.in);
            Letturadati letturaDati = new Letturadati();
            List<Map<String, String>> listOfDatiMaps = letturaDati.lettura(); 
            for (Map<String, String> datiMap : listOfDatiMaps) {
                
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
            else {
                posx=-1;
                posy=-1;
                pause=-1;
                testo = "";
                clik="";
            }
            Ricerca ricerca= new Ricerca();
            ricerca.eseguiRicerca(robot, posx, posy, testo, pause, clik);
            }
            sc.close();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
