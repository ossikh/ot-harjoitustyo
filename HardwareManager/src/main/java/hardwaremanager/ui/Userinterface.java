package hardwaremanager.ui;

import hardwaremanager.logics.Hardware;
import hardwaremanager.logics.Manager;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;


/**
 * Käyttöliittymästä vastaava luokka
 */

public class Userinterface {

    private Scanner reader;
    private Manager manager;

    public Userinterface(Scanner reader) {

        this.reader = reader;
        manager = new Manager();

    }

    public void start() {

        uiWelcomeMessage();
        uiBlankLine();

        while (true) {

            uiDisplayMenu();
            String action = reader.nextLine();

            if (action.equals("1")) {
                uiListHardware();
            }
            if (action.equals("2")) {
                uiAddHardware();
            }
            if (action.equals("3")) {
                uiTitleSearch();
            }
            if (action.equals("4")) {
                uiTypeSearch();
            }
            if (action.equals("5")) {
                uiLocationSearch();
            }
            if (action.toLowerCase().equals("r")) {
                uiRemoveHardware();
            }
            if (action.toLowerCase().equals("g")) {
                manager = crateGenericManager();
            }
            if (action.toLowerCase().equals("q")) {
                break;
            }

        }

    }

    public void uiDisplayMenu() {
        System.out.println("Available actions: ");
        System.out.println(""
                + "[1] List all hardware | "
                + "[2] Add hardware | "
                + "[3] Search by title | "
                + "[4] Search by type | "
                + "[5] Search by location | "
                + "[R] Remove hardware | "
                + "[G] Create generic hardware list for testing purposes | "
                + "[Q] Quit"
        );

        System.out.print("Select action: ");
    }

    public void uiWelcomeMessage() {
        System.out.println("-=[   Welcome to ICT Hardware Manager   ]=-");
    }

    public void uiRemoveHardware() {
        System.out.print("Enter number of hardware to remove: ");
        String remove = reader.nextLine();
        uiBlankLine();
        if (remove.length() < 10 && NumberUtils.isCreatable(remove) && manager.removeHardware(NumberUtils.createInteger(remove))) {
            System.out.println("Hardware removed!");
        } else {
            System.out.println("Hardware not removed!");
        }
        uiBlankLine();
    }

    public void uiListHardware() {
        System.out.println("Listing all hardware:");
        uiBlankLine();
        if (manager.hwlistNotEmpty()) {
            manager.listHardware();
        } else {
            System.out.println("No hardware found!");
        }
        uiBlankLine();
    }

    public void uiAddHardware() {
        System.out.print("Enter new hardware title: ");
        String title = reader.nextLine();
        System.out.print("Enter new hardware type: ");
        String type = reader.nextLine();
        System.out.print("Enter new hardware location: ");
        String location = reader.nextLine();
        manager.addHardware(new Hardware(title, type, location));
        System.out.println("Hardware added!");
    }

    public void uiTitleSearch() {
        System.out.print("Enter title search string: ");
        String title = reader.nextLine();
        System.out.println("Displaying items containing title '" + title + "': ");
        uiBlankLine();
        manager.searchByTitle(title);
        uiBlankLine();
    }

    public void uiTypeSearch() {
        System.out.print("Enter type search string: ");
        String type = reader.nextLine();
        System.out.println("Displaying items containing type '" + type + "': ");
        uiBlankLine();
        manager.searchByType(type);
        uiBlankLine();
    }

    public void uiLocationSearch() {
        System.out.print("Enter location search string: ");
        String location = reader.nextLine();
        System.out.println("Displaying items on location containing '" + location + "': ");
        uiBlankLine();
        manager.searchByLocation(location);
        uiBlankLine();
    }

    public void uiBlankLine() {
        System.out.println("");
    }

    public Manager crateGenericManager() {
        Manager manager = new Manager();
        manager.addHardware(new Hardware("Asus TUF B550", "Motherboard", "Main machine"));
        manager.addHardware(new Hardware("Ryzen 7 3700x", "Processor", "Main machine"));
        manager.addHardware(new Hardware("Corsair LPX DDR4-3200, 32GB", "Memory", "Main machine"));
        manager.addHardware(new Hardware("MSI Geforce GTX 1070 8 GB", "GPU", "Main machine"));
        manager.addHardware(new Hardware("Samsung 970 Evo Plus 1 TB", "NVMe", "Main machine"));
        manager.addHardware(new Hardware("Noctua NH-D15S", "Cooler", "Main machine"));
        manager.addHardware(new Hardware("Fractal Design R5", "Case", "Main machine"));
        manager.addHardware(new Hardware("AOC 32 IPS", "Monitor", "Main desk"));
        manager.addHardware(new Hardware("Logitech MX Keys wireless", "Keyboard", "Main desk"));
        manager.addHardware(new Hardware("ASUS ROG Strix Carry wireless", "Mouse", "Main desk"));
        uiBlankLine();
        System.out.println("Generic hardware list created!");
        uiBlankLine();
        return manager;
    }

}
