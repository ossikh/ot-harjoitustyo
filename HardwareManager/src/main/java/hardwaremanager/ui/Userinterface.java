package hardwaremanager.ui;

import hardwaremanager.logics.Hardware;
import hardwaremanager.logics.Manager;
import java.util.Scanner;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Käyttöliittymästä vastaava luokka
 */
public class Userinterface {

    private Scanner reader;
    private Manager manager;

    public Userinterface(Scanner reader) {

        this.reader = reader;
        this.manager = new Manager();

    }

    public void start() {
        uiWelcomeMessage();
        uiBlankLine();

        while (true) {
            uiDisplayMainMenu();
            String action = reader.nextLine();

            if (action.toLowerCase().equals("q")) {
                break;
            }
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
            if (action.toLowerCase().equals("m")) {
                uiModifyHardwareMenu();
            }
            if (action.toLowerCase().equals("r")) {
                uiRemoveHardware();
            }
            if (action.toLowerCase().equals("l")) {
                uiLoadHardwarelist();
            }
            if (action.toLowerCase().equals("s")) {
                uiSaveHardwarelist();
            }
            if (action.toLowerCase().equals("g")) {
                manager = crateGenericManager();
            }
        }
    }

    public void uiDisplayMainMenu() {
        System.out.println("Available actions: ");
        System.out.println(""
                + "[1] List all hardware | "
                + "[2] Add hardware | "
                + "[3] Search by title | "
                + "[4] Search by type | "
                + "[5] Search by location | "
                + "[M] Modify hardware | "
                + "[R] Remove hardware | "
                + "[L] Load hardware list from file | "
                + "[S] Save hardware list to a file | "
                + "[Q] Quit"
        );
        System.out.print("Select action: ");
    }

    public void uiWelcomeMessage() {
        System.out.println("-=[   Welcome to ICT Hardware Manager   ]=-");
    }

    public void uiModifyHardwareMenu() {
        System.out.print("Enter number of hardware to modify: ");
        String modify = reader.nextLine();
        if (modify.length() < 10 && NumberUtils.isDigits(modify) && manager.getHardware(NumberUtils.createInteger(modify)) != null) {
            int hwnumber = NumberUtils.createInteger(modify);
            while (true) {
                uiBlankLine();
                System.out.println("You are modifying the following hardware: " + manager.getHardware(hwnumber));
                uiBlankLine();
                System.out.println("Select field to modify: [1] Title | [2] Type | [3] Location | [C] Cancel action");
                System.out.print("Select action: ");
                String action = reader.nextLine();
                if (action.toLowerCase().equals("c")) {
                    break;
                }
                if (action.equals("1")) {
                    System.out.print("Enter new field for 'title': ");
                    String title = cullInput(reader.nextLine());
                    manager.getHardware(hwnumber).setTitle(title);
                    System.out.println("Title changed to '" + title + "'.");
                }
                if (action.equals("2")) {
                    System.out.print("Enter new field for 'type': ");
                    String type = cullInput(reader.nextLine());
                    manager.getHardware(hwnumber).setType(type);
                    System.out.println("Type changed to '" + type + "'.");
                }
                if (action.equals("3")) {
                    System.out.print("Enter new field for 'location': ");
                    String location = cullInput(reader.nextLine());
                    manager.getHardware(hwnumber).setLocation(location);
                    System.out.println("Location changed to '" + location + "'.");
                }
            }
        }
    }

    public String cullInput(String input) {
        while (true) {
            if (StringUtils.isNotBlank(input) && !input.contains(";") && input.length() <= 50) {
                break;
            } else {
                System.out.print("Input cannot be blank, longer than 50 characters, or contain the following character ';' - please try again: ");
                input = reader.nextLine();
            }
        }
        return input;
    }

    public void uiSaveHardwarelist() {
        System.out.print("Enter the filename to save current hardware list as: ");
        String filename = reader.nextLine();
        manager.saveHardwarelist(filename);
    }

    public void uiLoadHardwarelist() {
        System.out.print("Enter the filename of hardware list to load: ");
        String filename = reader.nextLine();
        manager.loadHardwarelist(filename);
    }

    public void uiRemoveHardware() {
        System.out.print("Enter number of hardware to remove: ");
        String remove = reader.nextLine();
        uiBlankLine();
        if (!confirmationCheck()) {
            return;
        }
        if (remove.length() < 10 && NumberUtils.isDigits(remove) && manager.removeHardware(NumberUtils.createInteger(remove))) {
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
        String title = cullInput(reader.nextLine());
        System.out.print("Enter new hardware type: ");
        String type = cullInput(reader.nextLine());
        System.out.print("Enter new hardware location: ");
        String location = cullInput(reader.nextLine());
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
    
    public void uiAutoloadHardwarelist(String filename){
        manager.loadHardwarelist(filename);
    }

    public boolean confirmationCheck() {
        System.out.print("Confirmation required, press 'Y' and Enter to proceed: ");
        return (reader.nextLine().toLowerCase().equals("y"));
    }

    public Manager crateGenericManager() {
        Manager manager = new Manager();
        manager.addHardware(new Hardware("Asus TUF Gaming B550-Plus", "Motherboard", "Main machine"));
        manager.addHardware(new Hardware("Ryzen 7 3700X", "Processor", "Main machine"));
        manager.addHardware(new Hardware("Corsair LPX DDR4-3200, 32 GB", "Memory", "Main machine"));
        manager.addHardware(new Hardware("MSI GeForce GTX 1070 8 GB", "GPU", "Main machine"));
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
