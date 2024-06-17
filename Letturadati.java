import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Letturadati {

    private HashMap<String, String> datiMap; // Use HashMap to store key-value pairs

    public HashMap<String, String> lettura() {
        datiMap = new HashMap<>(); // Initialize the HashMap

        try {
            File myObj = new File("dati.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                // Check if the line starts with "posxy="
                if (line.startsWith("posxy=")) {
                    // Extract the coordinates
                    String coordinates = line.substring(line.indexOf('=') + 1);
                    String[] parts = coordinates.split(",");
                    if (parts.length == 2) {
                        // Insert posx and posy into the HashMap
                        datiMap.put("posx", parts[0].trim());
                        datiMap.put("posy", parts[1].trim());
                    }
                } else {
                    // Split line into key-value pairs for other data
                    String[] pairs = line.split(";");
                    for (String pair : pairs) {
                        // Split each pair by '=' to get key and value
                        String[] keyValue = pair.split("=");
                        if (keyValue.length == 2) { // Ensure there's a key and a value
                            // Trim and store in HashMap
                            datiMap.put(keyValue[0].trim(), keyValue[1].trim());
                        }
                    }
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return datiMap; // Return the populated HashMap
    }
}