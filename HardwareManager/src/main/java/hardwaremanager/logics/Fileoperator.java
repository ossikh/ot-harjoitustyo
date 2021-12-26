package hardwaremanager.logics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Tiedoston luku- ja kirjoitusoperaatioista vastaava luokka
 */
public class Fileoperator {

    /**
     * Lataa komponenttilistan tiedostosta
     *
     * @param filename tiedostonimi josta lista ladataan, lisää automaattisesti
     * .hwm päätteen
     * @return palauttaa tiedostosta luetun komponenttilistan
     */
    public ArrayList<Hardware> loadList(String filename) {
        filename += ".hwm";
        ArrayList hwlist = new ArrayList();
        try {
            Scanner reader = new Scanner(new File(filename));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                hwlist.add(new Hardware(parts[0], parts[1], parts[2]));
            }
            System.out.println("Hardware list loaded from " + filename + "!");
        } catch (FileNotFoundException e) {
            System.out.println("Error opening " + filename + " - file not found!");
        }
        return hwlist;
    }

    /**
     * Tallentaa komponenttilistan tiedostoon
     *
     * @param filename tiedostonimi johon komponenttilista tallennetaan, lisää
     * automaattiesti .hwm päätteen
     * @param hwlist komponenttilista joka tallennetaan tiedostoon     
     */
    public void saveList(String filename, ArrayList<Hardware> hwlist) {
        filename += ".hwm";
        try (FileWriter writer = new FileWriter(new File(filename))) {
            for (Hardware h : hwlist) {
                writer.write(h.getTitle() + ";" + h.getType() + ";" + h.getLocation() + "\n");
            }
            System.out.println("Hardware list saved as " + filename + "!");
        } catch (Exception e) {
            System.out.println("Error saving file " + filename + "!");
        }
    }

}
