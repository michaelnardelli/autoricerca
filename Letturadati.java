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
                // Split line into key-value pairs
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

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return datiMap;
    }
    public static int[] parsePosition(String input) {
        // Step 1: Remove the prefix
        String coordinates = input.substring(input.indexOf('=') + 1);
        // Step 2: Split the string by comma
        String[] parts = coordinates.split(",");
        // Step 3: Parse and assign to posx and posy
        int posx = Integer.parseInt(parts[0]);
        int posy = Integer.parseInt(parts[1]);
        // Return posx and posy
        return new int[]{posx, posy};
    }

    public static void main(String[] args) {
        String input = "posxy=200,100";
        int[] positions = parsePosition(input);
        System.out.println("posx: " + positions[0] + ", posy: " + positions[1]);
    }
}
    
    @Override
    public String toString() {
        // Use HashMap's toString method for representation
        return datiMap.toString();
    }
}