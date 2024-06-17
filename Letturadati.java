import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Letturadati {

    private ArrayList<String> dati2; // Use ArrayList instead of array

    public ArrayList<String> lettura() {
        dati2 = new ArrayList<String>(); // Initialize the ArrayList

        try {
            File myObj = new File("dati.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                dati2.add(myReader.nextLine()); // Add lines to the ArrayList
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return dati2;
    }

    @Override
    public String toString() {
        // ArrayList's toString method provides a string representation
        return dati2.toString() + " retroun the addres";
    }
}