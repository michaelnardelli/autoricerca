package ricerca2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Letturadati {

    private HashMap<String, String> datiMap = new HashMap<>(); // Use HashMap to store key-value pairs

    public List<Map<String, String>> lettura() {
        
        
        List<Map<String, String>> listOfDatiMaps = new ArrayList<>();

        try {
            File myObj = new File("dati.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\\Z"); 
            String content = myReader.next(); 
            String[] blocks = content.split("\\}"); 
            for (String block : blocks) {
                block = block.replace("{", "").trim(); 
                if (block.isEmpty())
                    continue; 

                Map<String, String> blockMap = new HashMap<>();
                String[] lines = block.split(";");
                for (String line : lines) {
                    if (line.contains("=")) {
                        String[] parts = line.split("=");
                        if (parts.length == 2) { 
                            String key = parts[0].trim();
                            String value = parts[1].trim();
                            blockMap.put(key, value);
                        }
                    }
                }
                listOfDatiMaps.add(blockMap); 
          
        }   myReader.close();
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return listOfDatiMaps;
    }
}