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

        while (true) {
            uiBlankLine();
            uiDisplayMainMenu();
            String action = uiGetAction();

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
                uiModifyHardwareSubMenu();
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
                + "[L] Load hardware list from a file | "
                + "[S] Save hardware list to a file | "
                + "[Q] Quit"
        );
    }

    public void uiWelcomeMessage() {
        System.out.println("-=[   Welcome to ICT Hardware Manager   ]=-");
    }

    public void uiModifyHardwareSubMenu() {
        uiListHardware();
        System.out.print("Enter ID number of hardware to modify: ");
        String modify = reader.nextLine();
        if (modify.length() < 10 && NumberUtils.isDigits(modify) && manager.getHardware(NumberUtils.createInteger(modify)) != null) {
            int hwnumber = NumberUtils.createInteger(modify);
            while (true) {
                uiBlankLine();
                System.out.println("You are modifying the following hardware: " + hwnumber + ". " + manager.getHardware(hwnumber));
                uiBlankLine();
                System.out.println("Select field to modify: [1] Title | [2] Type | [3] Location | [C] Return to main menu");
                String action = uiGetAction();
                if (action.toLowerCase().equals("c")) {
                    break;
                }
                if (action.equals("1")) {
                    String originalTitle = manager.getHardware(hwnumber).getTitle();
                    System.out.print("Enter new title to replace '" + originalTitle + "': ");
                    String newTitle = uiCullInput(reader.nextLine());
                    System.out.println("You are about to change '" + originalTitle + "' to '" + newTitle + "'.");
                    if (uiConfirmationCheck()) {
                        manager.getHardware(hwnumber).setTitle(newTitle);
                        System.out.println("Title changed from '" + originalTitle + "' to '" + newTitle + "'.");
                    }
                }
                if (action.equals("2")) {
                    String originalType = manager.getHardware(hwnumber).getType();
                    System.out.print("Enter new type to replace '" + originalType + "': ");
                    String newType = uiCullInput(reader.nextLine());
                    System.out.println("You are about to change '" + originalType + "' to '" + newType + "'.");
                    if (uiConfirmationCheck()) {
                        manager.getHardware(hwnumber).setType(newType);
                        System.out.println("Type changed from '" + originalType + "' to '" + newType + "'.");
                    }
                }
                if (action.equals("3")) {
                    String originalLocation = manager.getHardware(hwnumber).getLocation();
                    System.out.print("Enter new location to replace '" + originalLocation + "': ");
                    String newLocation = uiCullInput(reader.nextLine());
                    System.out.println("You are about to change '" + originalLocation + "' to '" + newLocation + "'.");
                    if (uiConfirmationCheck()) {
                        manager.getHardware(hwnumber).setLocation(newLocation);
                        System.out.println("Location changed from '" + originalLocation + "' to '" + newLocation + "'.");
                    }
                }
            }
        }
    }

    public String uiCullInput(String input) {
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

    public String uiGetAction() {
        System.out.print("Select action: ");
        return reader.nextLine();
    }

    public void uiSaveHardwarelist() {
        System.out.print("Enter the filename to save current hardware list as: ");
        String filename = uiCullInput(reader.nextLine());
        System.out.println("You are about to save hardware list as " + filename + ".hwm");
        if (uiConfirmationCheck()) {
            manager.saveHardwarelist(filename);
        }
    }

    public void uiLoadHardwarelist() {
        System.out.print("Enter the filename of hardware list to load: ");
        String filename = reader.nextLine();
        System.out.println("You are about to try and load " + filename + ".hwm, any unsaved changes will be lost when loading another list!");
        if (uiConfirmationCheck()) {
            manager.loadHardwarelist(filename);
        }
    }

    public void uiRemoveHardware() {
        System.out.print("Enter number of hardware to remove: ");
        String remove = reader.nextLine();
        uiBlankLine();
        if (!uiConfirmationCheck()) {
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
        String title = uiCullInput(reader.nextLine());
        System.out.print("Enter new hardware type: ");
        String type = uiCullInput(reader.nextLine());
        System.out.print("Enter new hardware location: ");
        String location = uiCullInput(reader.nextLine());
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

    public void uiAutoloadHardwarelist(String filename) {
        manager.loadHardwarelist(filename);
    }

    public boolean uiConfirmationCheck() {
        System.out.print("Confirmation required, press 'Y' and Enter to proceed with action: ");
        if (reader.nextLine().toLowerCase().equals("y")) {
            return true;
        } else {
            System.out.println("Action aborted!");
        }
        return false;
    }
}
