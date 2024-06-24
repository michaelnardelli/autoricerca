package ricerca2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Letturadati {

    private HashMap<String, String> datiMap; // Use HashMap to store key-value pairs

    public List<Map<String, String>> lettura() {
        datiMap = new HashMap<>(); // Initialize the HashMap
        List<Map<String, String>> listOfDatiMaps = new ArrayList<>();

        try {
            File myObj = new File("dati.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\\Z"); // Set delimiter to end of file
            String content = myReader.next(); // Read the entire file content
            myReader.close(); // Close the scanner

            String[] blocks = content.split("\\}"); // Assume blocks are separated by "}"
            for (String block : blocks) {
                block = block.replace("{", "").trim(); // Clean up block
                if (block.isEmpty())
                    continue; // Skip empty blocks

                Map<String, String> blockMap = new HashMap<>();
                String[] lines = block.split(";");
                for (String line : lines) {
                    if (line.contains("=")) {
                        String[] parts = line.split("=");
                        if (parts.length == 2) { // Ensure there's a key and a value
                            String key = parts[0].trim();
                            String value = parts[1].trim();
                            blockMap.put(key, value);
                            /*
                             * if (key.equals("posxy")) {
                             * // Split posxy into posx and posy
                             * //String[] posParts = value.split(",");
                             * //if (posParts.length == 2) {
                             * // blockMap.put("posx", posParts[0].trim());
                             * blockMap.put("posy", posParts[1].trim());
                             * }
                             * } else {
                             * // Store in HashMap
                             * }
                             */
                        }
                    }
                }
                listOfDatiMaps.add(blockMap); // Add the processed map to the list
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return listOfDatiMaps;
    }
}